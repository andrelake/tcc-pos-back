package com.tcc.tccback.repository;

import com.tcc.tccback.model.fornecedor.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

    Optional<Fornecedor> findByNome(String nome);

    @Query(value = "SELECT * FROM fornecedor f WHERE f.id IN (:fornecedoresIds)",
            nativeQuery = true)
    List<Fornecedor> findByIdIn(@Param("fornecedoresIds") List<Long> fornecedoresIds);
}
