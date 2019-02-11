package poc;

import java.io.Serializable;

public class SimpleMessage  implements Serializable {
    private String nome;
    private String description;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return nome + " - "+ description;
    }
}
