# art-of-enbugging

## Enbugging
	Práticas a serem adotadas/evitadas, para prevenir bugs gerados a partir de futuras alterações ao código. Future Proofing.
	Quando se faz códigos, é extremamente comum criar situações que geram condições para que um bug aconteça. Um bug é quando a linguagem do computador entra em conflito e gera uma impossibilidade de continuar a execução de um programa. Esses bugs tendem a acumular quanto maior e menos “limpo” um código for. Ao limpar o código após escrever tantas linhas, no período de revisão, acaba-se aumentando consideravelmente o tempo do trabalho de programação pois muito dos erros realizados são de origem semântica, onde várias linhas de código precisam ser reescritas, como se criasse um “ninho” onde a proliferação de bugs é exponencial. Entretanto, um dos tipos de prática que é mais atribuída a tais problemas é quando não existe um bom encapsulamento de métodos, criando uma longa lista de chamados. O nome designado por programadores a tais códigos é “Trainwreck Code” (Código Acidente-de-trem ou naufrágio).
  
## Trainwreck Code
	Acidentes de trem no mundo real deixam uma trilha de vagões descarrilhados um em cima do outro, como se fossem pilhas feitas motivo ou razão. No mundo da programação, algo parecido ocorre quando não ocorre o encapsulamento de um método ou objeto. O termo “Trainwreck Code” vem desse resultado: uma corrente de chamados que lembra um acidente de trens, geralmente inclui chamados a métodos que não necessariamente deviam ser públicos.
```
  void assistirTvGlobinho(){
    if(tv.getStatus() == "desligada"){
      tv.getBotao("Ligar").apertar();
      tv.setStatus("ligada");
    }
    tv.getBotao("1").apertar();
    tv.getBotao("8").apertar();
    ...
  }
  
  class Tv{
  //getters e setters
  }
```
  Nós podemos introduzir métodos intermediarios que lidam com os chamados, para que os outros objetos possam focar em sua própria lógica.
```
  void assistirTvGlobinho(){
    tv.ligar();
    tv.mudarCanal("18");
  }
  
  class Tv{
    //getters e setters
    void ligar(){
      ...
    }
    void desligar(){
      ...
    }
    void mudarCanal(){
      ...
    }
    ...
  }
  
  
