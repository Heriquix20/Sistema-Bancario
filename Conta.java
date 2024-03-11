import java.util.Scanner;

public class Conta {
    
    private String cpf;
    private String nome;
    private double saldo;
    private String senha;

///// Construtor
    public Conta() {}

///// To String   
    @Override
    public String toString() {
        return "Nome = " + nome + "\nCPF: " + cpf + "\nSaldo: " + saldo;
    }
    

//// Método para verificar senha
public void verificarSenha(Scanner sc) {
    sc.nextLine();
        boolean condicao;
        String senhaDigitada;
        int contador = 0;
do {  System.out.print("Digite sua senha para continuar: ");
      senhaDigitada = sc.nextLine();
      if (senhaDigitada.equals(senha)) {
        condicao = true;
        System.out.println("\nLogin realizado com sucesso!!");
        break;
    } 
      else  {
        contador++;
        condicao = false;
        System.out.println("Senha incorreta!");
}
      if (contador >= 3) {
        System.out.println("Senha digitada errada 3 vezes\n Encerrando o programa...");
        System.exit(0);
    }
    }   while(contador < 3 && condicao == false);
}


///// Método para mudar senha
public void mudarSenha(Scanner sc) {
    boolean condicaoDois;
    String senhaDigitada;
    int contadorDois = 0;
    do {
        System.out.println("Digite a senha atual para continuar:");
        senhaDigitada = sc.nextLine();
          if (senhaDigitada.equals(getSenha())) {
                System.out.print("Insira a nova senha: ");
                String novaSenha = sc.nextLine();
                setSenha(novaSenha);
                System.out.println("Senha atualizada");
                condicaoDois = true;
            }
            else {
                condicaoDois = false;
                contadorDois++;
                System.out.println("Senha incorreta!");
            }
            if (contadorDois >= 3) {
                System.out.println("Senha digitada errada 3 vezes\n Encerrando o programa...");
                System.exit(0);
            }
    }while(condicaoDois == false && contadorDois < 3 );
}


///// Métodos de pagamento

///// Dinheiro ou pix
    public void calcularDinheiroPix(double produto) {
        double resultDinheiroPix = (15 * produto) / 100;
        double total = produto - resultDinheiroPix;
        if (saldo > produto) {
            saldo = saldo - total;
            System.out.println("Compra realizada com sucesso!!");
            System.out.println("Desconto de 15% aplicado, valor a pago na compra: R$" + total);
            System.out.println("Saldo atual: R$" + saldo);
        }
            else {
                System.out.println("Saldo insuficiente ");
                System.out.println("Saldo atual: R$" + saldo);
        }  
    }

///// Á vista no cartão
    public void calcularAvistaCartao(double produto) {
        double resultVistaCartao = (10 * produto) / 100;
        double totalDois = produto - resultVistaCartao;
        if (saldo > produto) {
            saldo = saldo - totalDois;
            System.out.println("Compra realizada com sucesso!!");
            System.out.println("Desconto de 10% aplicado, valor a pago na compra: R$" + totalDois);
            System.out.println("Saldo atual: R$" + saldo);
            }
            else {
                System.out.println("Saldo insuficiente");
                System.out.println("Saldo atual: R$" + saldo);
            }
    }

///// Parcelado
    public void calcularParcelado(double produto) {
        double result = (10 * produto) / 100;
        double somaFinal = result + produto;
        if (saldo > produto) {
            saldo = saldo - somaFinal;
            System.out.println("Compra realizada com sucesso!!");
            System.out.println("Juros de 10% aplicado no produto, valor pago na compra: R$" + somaFinal);
            System.out.println("Saldo atual: R$" + saldo);
            }
            else {
                System.out.println("Saldo insuficiente");
                System.out.println("Saldo atual: R$" + saldo);
            }
    }

///// Comprar
    public void comprar(double produto) {
        if (saldo > produto) {
            saldo = saldo - produto;
            System.out.println("Compra realizada com sucesso!!");
            System.out.println("Valor pago na compra: R$" + produto);
            System.out.println("Saldo atual: R$" + saldo);
            }
            else {
                System.out.println("Saldo insuficiente");
                System.out.println("Saldo atual: R$" + saldo);
            }
    }


/////Depositar
    public void depositar(Scanner sc) {
        System.out.println("Insira o valor a depositar: ");
        double deposito = sc.nextDouble();
        saldo = saldo + deposito;
        System.out.printf("Depósito de " + deposito + " realizado com sucesso,\nSaldo atual: %.2f" , saldo);
    }

///// Sacar
    public void sacar(Scanner sc) {
        boolean condicaoTres;
        do {
            System.out.println("Insira o valor a sacar: ");
            double saque = sc.nextDouble();
            if (saque <= saldo) {
                condicaoTres = true;
                saldo = saldo - saque;
                System.out.printf("Saque de " + saque + " realizado com sucesso\nSaldo atual: %.2f" , saldo);
            }
            else {
                condicaoTres = false;
                System.out.println("Valor de saque indisponível, insira um valor válido");
            }
        }   while(condicaoTres == false);
    }



//// Gets e Sets
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

     public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
