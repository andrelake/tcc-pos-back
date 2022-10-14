package com.tcc.tccback.model.dashboard.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class DashboardDTO {

    private Integer qtdProdutos = 0;
    private BigDecimal valorTotalProdutos = BigDecimal.ZERO;
    private BigDecimal precoMedioProdutos = BigDecimal.ZERO;
    private Integer qtdFornecedores = 0;
    private Integer qtdCategorias = 0;

}
