package edu.fatec.sjc.lp2.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Peca {
    private Motor motor;

    public void ligarMotor(){
        motor.ligar();
    }
}
