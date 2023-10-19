package dio.projetoFinal.model;


import javax.persistence.*;
import java.util.List;
import dio.projetoFinal.model.FundosImobiliarios;

@Entity
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FundosImobiliarios> fundos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<FundosImobiliarios> getFundos() {
        return fundos;
    }

    public void setFundos(List<FundosImobiliarios> fundos) {
        this.fundos = fundos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
