package edu.fatec.sjc.lp2.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Painel {
    private Peca peca;

    public void ligarMotor(){
        peca.ligarMotor();
    }
}
