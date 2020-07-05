# art-of-enbugging

## Enbugging
Quando se faz códigos, é extremamente comum criar situações que geram condições para que um bug aconteça. Esses bugs tendem a acumular quanto maior e menos “limpo” um código for. Ao limpar o código após escrever tantas linhas, no período de revisão, acaba-se aumentando consideravelmente o tempo do trabalho de programação pois muito dos erros realizados são de origem semântica, onde várias linhas de código precisam ser reescritas, como se criasse um “ninho” onde a proliferação de bugs é exponencial. Entretanto, um dos tipos de prática que é mais atribuída a tais problemas é quando não existe um bom encapsulamento de métodos, criando uma longa lista de chamados. O nome designado por programadores a tais códigos é “Trainwreck Code”.

The art of enbugging: https://media.pragprog.com/articles/jan_03_enbug.pdf

## Trainwreck Code
Acidentes de trem no mundo real deixam uma trilha de vagões descarrilhados um em cima do outro, como se fossem pilhas feitas motivo ou razão. No mundo da programação, algo parecido ocorre quando não ocorre o encapsulamento de um método ou objeto. O termo “Trainwreck Code” vem desse resultado: uma corrente de chamados que lembra um acidente de trens, geralmente inclui chamados a métodos que não necessariamente deviam ser públicos.
```Java
  void assistirTvGlobinho(){
    if(tv.getStatus() == "desligada"){
      tv.getBotao("Ligar")
        .apertar();
      tv.setStatus("ligada");
    }
    tv.getBotao("1")
      .apertar();
    tv.getBotao("8")
      .apertar();
    ...
  }
  
  class Tv{
  //getters e setters
  }
```
Train Wreck - Code Smell: https://devcards.io/train-wreck  
Train Wreck Pattern – A much improved implementation in Java 8: https://dzone.com/articles/train-wreck-pattern-%E2%80%93-much  
How many train wrecks are lurking in your code?: http://www.thinkcode.se/blog/2011/12/30/how-many-train-wrecks-are-lurking-in-your-code  

## Shy Code
Shy Codes ou “códigos tímidos” são códigos que não revelam muito de si para outros e não fala a não ser que seja necessário. Portanto, as classes só compartilham o que precisam compartilhar e longas correntes de chamados são encapsulados em métodos com nomes explícitos. Quando um código não é tímido, ocorrem acoplamentos que você não deseja. Entre eles os mais comuns são acoplamento estático, dinâmico, de domínio e temporal. 

- Estático:
  É quando um pedaço de código necessita de outro para compilar. Isso não é ruim, desde que um pedaço não carregue muita “bagagem” consigo. 

- Dinâmico:
  Ocorre quando um pedaço de código necessita de outro para rodar. Se não houver cuidado, é aí que temos o principal motivo para transformar um código tímido em um trainwreck.

- Domínio:
  Acontece quando as leis e políticas de uma empresa são escritas no código, entrelaçando regras externas de trabalho com as internas de programação. Isso também não é ruim, mas se deve ter controle, principalmente se as regras são voláteis, ou seja, tendem a mudar de forma constante. 

- Temporal:
  É quando partes do código devem ocorrer em uma certa ordem, em um certo tempo limite, ou se várias partes devem rodar ao mesmo tempo. Dependendo de quão “descarrilhado” o código esteja, ele pode não ocorrer no tempo que é desejado. Este acoplamento ocorre naturalmente quanto mais complexo for o programa.

Nós podemos introduzir métodos intermediarios que lidam com os chamados, para que os outros objetos possam focar em sua própria lógica.
```Java
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
```
Para que seja possível ter um código tímido normalmente se aplicam algumas boas práticas de programação, uma das melhores sendo a verificação se o programa atende a chamada Lei de Deméter.

## Lei de Demeter:
A Lei de Deméter pode ser resumida da seguinte forma:
- Cada unidade deve ter conhecimento limitado sobre outras unidades: apenas unidades próximas se relacionam. 
- Cada unidade deve apenas conversar com seus amigos; Não fale com estranhos. 
- Apenas fale com seus amigos imediatos.

Apesar de não ser uma lei obrigatória, um código que segue a Lei de Deméter acaba por ter baixo acoplamento por natureza. Isso o torna tímido e mantém o isolamento das partes em níveis mais aceitáveis, e evitando a possibilidade de bugs. Essa lei reduz a quantidade de dependências e cria componentes que são fracamente acoplados, diminuindo a necessidade de revisitar o código ou até de achar bugs, se existirem.

Stop Violating The Law Of Demeter, Keep Your Code Loosely Coupled: https://levelup.gitconnected.com/stop-violating-the-law-of-demeter-keep-your-code-loosely-coupled-4c86a2f2cf70
