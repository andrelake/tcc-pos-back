package com.tcc.tccback.service.dashboard;

import com.tcc.tccback.model.dashboard.dto.DashboardDTO;
import com.tcc.tccback.model.produto.dto.ProdutoDTO;
import com.tcc.tccback.service.categoria.CategoriaFindService;
import com.tcc.tccback.service.fornecedor.FornecedorFindService;
import com.tcc.tccback.service.produto.ProdutoFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    private ProdutoFindService produtoFindService;
    @Autowired
    private FornecedorFindService fornecedorFindService;
    @Autowired
    private CategoriaFindService categoriaFindService;

    public DashboardService(ProdutoFindService produtoFindService,
                            FornecedorFindService fornecedorFindService,
                            CategoriaFindService categoriaFindService) {
        this.produtoFindService = produtoFindService;
        this.fornecedorFindService = fornecedorFindService;
        this.categoriaFindService = categoriaFindService;
    }

    public DashboardDTO geraDashboardInfo() {
        List<ProdutoDTO> listaProd = produtoFindService.findAll().stream().filter(prod -> prod.isAtivo()).collect(Collectors.toList());
        int qtdProdutos = 0;
        for (ProdutoDTO prod : listaProd) {
            int quantidade = prod.getQuantidade();
            qtdProdutos = qtdProdutos + quantidade;
        }

        BigDecimal valorTotalProd = BigDecimal.ZERO;
        for (ProdutoDTO prod : listaProd) {
            BigDecimal valorTotalDoProduto = prod.getPrecoUnitario().multiply(BigDecimal.valueOf(prod.getQuantidade()));
            valorTotalProd = valorTotalProd.add(valorTotalDoProduto);
        }

        BigDecimal precoMedioProd = valorTotalProd.divide(BigDecimal.valueOf(qtdProdutos), RoundingMode.HALF_UP);

        int qtdForn = fornecedorFindService.findAll().stream().filter(forn -> forn.isAtivo()).collect(Collectors.toList()).size();

        int qtdCat = categoriaFindService.findAll().stream().filter(cat -> cat.isAtivo()).collect(Collectors.toList()).size();

        return DashboardDTO.builder()
                .qtdProdutos(qtdProdutos)
                .valorTotalProdutos(valorTotalProd)
                .precoMedioProdutos(precoMedioProd)
                .qtdFornecedores(qtdForn)
                .qtdCategorias(qtdCat)
                .build();
    }
}
