import java.util.Scanner;

public class App {

    public static String avaliarSenha(String senha) {
        if (senha.length() < 8) {
            return "DICA: A senha deve ter no minimo 8 caracteres.";
        }

        boolean temNumero = false;
        for (int i = 0; i < senha.length(); i++) {
            if (Character.isDigit(senha.charAt(i))) {
                temNumero = true;
                break;
            }
        }
        if (!temNumero) {
            return "DICA: Adicione pelo menos um número à sua senha.";
        }

        String[] senhasObvias = {"12345678", "senha123", "admin123"};
        for (int i = 0; i < senhasObvias.length; i++) {
            if (senha.equals(senhasObvias[i])) {
                return "ALERTA: Esta senha é muito comum ou óbvia.";
            }
        }

        boolean temMaiuscula = false;
        for (int i = 0; i < senha.length(); i++) {
            if (Character.isUpperCase(senha.charAt(i))) {
                temMaiuscula = true;
                break;
            }
        }
        if (!temMaiuscula) {
            return "DICA: Adicione pelo menos uma letra maiúscula à sua senha.";
        }

        return "SUCESSO: Sua senha passou nos critérios básicos!";
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String resultado = "";

        while (!resultado.startsWith("SUCESSO")) {
            System.out.print("Digite uma senha para avaliação: ");
            String senhaDigitada = leitor.nextLine();

            resultado = avaliarSenha(senhaDigitada);
            System.out.println(resultado);
            System.out.println();
        }

        leitor.close();
    }
}


