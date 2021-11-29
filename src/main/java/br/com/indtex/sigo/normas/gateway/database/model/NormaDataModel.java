package br.com.indtex.sigo.normas.gateway.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "norma")
@Table(name = "norma", uniqueConstraints =
    @UniqueConstraint(name = "UK_CODIGO", columnNames = "codigo")
)
@Data
@AllArgsConstructor
public class NormaDataModel {

    @Id
    private Integer id;
    private String codigo;
    private String nome;
    private String descricao;
    private String area;
    private String tipo;
    private LocalDate dataRegistro;
    private LocalDateTime dataUltimaAtualizacao;
    @OneToMany(mappedBy = "norma", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AnexoDataModel> anexos;

    public NormaDataModel(Integer id, String codigo, String nome, String descricao, String area, String tipo, LocalDate dataRegistro, LocalDateTime dataUltimaAtualizacao) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.area = area;
        this.tipo = tipo;
        this.dataRegistro = dataRegistro;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }
}
