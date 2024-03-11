import java.util.Scanner;

public class Pagamento {
    public static void main(String[] args) {

    /////Instaciar as classes
        Scanner sc = new Scanner(System.in);
        Conta c = new Conta();

    ///// Variáveis
        String nome, senha, cpf;
        int caso, casoDois;
        double saldo = 5000, produto = 3560;

    ///// Início do Programa
        System.out.println("\nOlá, realize o cadastro para que possamos começar!!");
        System.out.print("\nDigite seu nome: ");
        nome = sc.nextLine();
        c.setNome(nome);

        System.out.print("\nDigite seu CPF(Apenas números): ");
        cpf = sc.nextLine();
        c.setCpf(cpf);

        System.out.print("\nAgora crie uma senha: ");
        senha = sc.nextLine();
        c.setSenha(senha);

        System.out.println("\nBem vindo " + nome + "!!!\n");
        System.out.println("Você tem um saldo inicial de 5000 reais, faça bom uso!");
        c.setSaldo(saldo);
        System.out.println(c);


    ///// Escolha do usuário
do {
   do {System.out.println("\nO que deseja fazer " + c.getNome() + "?");
      System.out.println("[1]-Comprar o The package");
      System.out.println("[2]-Alterar senha");
      System.out.println("[3]-Depositar");
      System.out.println("[4]-Sacar");
      System.out.println("[5]-Sair");
      caso = sc.nextInt();
      if (caso > 5) {
        System.out.println("Opção inválida, tente novamente");
      }
      } while(caso > 5);


    ///// primeiro switch
    switch(caso) {
        case 1:
        c.verificarSenha(sc);
    do {
        System.out.println("\nTotal: R$3560,00 \nEscolha a forma de pagamento:\n");
        System.out.println("[1] - À Vista em Dinheiro ou Pix, recebe 15% de desconto");
        System.out.println("[2] - À Vista no cartão de crédito, recebe 10% de desconto");
        System.out.println("[3] - Parcelado no cartão em duas vezes, preço normal do produto sem juros");
        System.out.println("[4] - Parcelado no cartão em três vezes ou mais, preço normal do produto mais juros de 10%");
        casoDois = sc.nextInt();
        if (casoDois > 4) {
            System.out.println("Opção inválida, tente novamente");
        }
       } while(casoDois > 4);


///// switch dentro do switch

        switch (casoDois) {

            case 1:
            c.calcularDinheiroPix(produto);
            break;

            case 2:
            c.calcularAvistaCartao(produto);
            break;

            case 3:
            c.comprar(produto);
            break;

            case 4:
            c.calcularParcelado(produto);
            break;
            
            case 5 :
            break;
        } break;


    ///// retorna ao primeiro switch

    ///// mudar senha
        case 2:
        sc.nextLine();
        c.mudarSenha(sc);
        break;

    ///// Depositar
        case 3:
        c.verificarSenha(sc);
        c.depositar(sc);
        break;

    ///// Sacar
        case 4:
        c.verificarSenha(sc);
        c.sacar(sc);
        break;

        case 5:
        System.out.println("Obrigado " + c.getNome() + " volte sempre!!");
        break;
    }

} while(caso < 5);

        sc.close();
    }
}
