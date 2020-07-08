package edu.fatec.sjc.lp2.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ArtOfEnbugging {
    private Carro carro;

    public void ligarOCarroIlegalmente()
    {
        carro.getPainel().getPeca().getMotor().ligar();
    }
    
    public void ligarOCarroSeguindoALei()//de Demeter
    {
        carro.ligarMotor();
    }


}
