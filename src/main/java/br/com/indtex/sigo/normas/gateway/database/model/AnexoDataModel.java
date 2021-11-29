package br.com.indtex.sigo.normas.gateway.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "anexo")
@Data
@AllArgsConstructor
public class AnexoDataModel {

    @Id
    private long id;
    private String nome;
    private String tipo;
    private String link;

    @JoinColumn(name = "id_norma", referencedColumnName = "id", unique = true)
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private NormaDataModel norma;
}
