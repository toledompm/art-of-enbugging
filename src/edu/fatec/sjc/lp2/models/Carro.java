package edu.fatec.sjc.lp2.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Carro {
    private Painel painel;

    public void ligarMotor(){
        painel.ligarMotor();
    }
}
