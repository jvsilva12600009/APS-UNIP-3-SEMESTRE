package javaapplication1;
import javax.swing.JOptionPane;
public class Main {
    static CalculadoraConsumo calc = new CalculadoraConsumo();
    static String[] tipos = new String[100];
    static int[] quantidades = new int[100];
    static double[] consumos = new double[100];
    static int contador = 0;
    static double meta = 0;
    public static void main(String[] args) {
        int opcao = 0;
        while (opcao != 6) {
            opcao = mostrarMenu();
            if (opcao == 1) {
                calcularUso();
            } else if (opcao == 2) {
                mostrarInformacoes();
            } else if (opcao == 3) {
                mostrarHistorico();
            } else if (opcao == 4) {
                limparHistorico();
            } else if (opcao == 5) {
                definirMeta();
            } else if (opcao == 6) {
                sair();
            } else {
                JOptionPane.showMessageDialog(null, "Opcao invalida.");
            }
        }
    }
    // ================= MENU =================
    public static int mostrarMenu() {
        String menu = "CONTROLE DE USO DE PLASTICO\n\n1 - Calcular uso\n2 - Informacoes\n3 - Ver historico\n4 - Limpar historico\n5 - Definir meta\n6 - Sair";
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }
    // ================= CALCULO =================
    public static void calcularUso() {
    int tipo = 0;
    while (tipo != 1 && tipo != 2 && tipo != 3) {
        tipo = Integer.parseInt(JOptionPane.showInputDialog("Escolha o tipo:\n1 - Sacola\n2 - Garrafa\n3 - Embalagem"));

        if (tipo != 1 && tipo != 2 && tipo != 3) {
            JOptionPane.showMessageDialog(null, "Opcao invalida. Digite 1, 2 ou 3.");
        }
    }
    int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade:"));
    double consumoUnitario = calc.obterConsumoPadrao(tipo);
    double total = calc.calcularConsumoTotal(quantidade, consumoUnitario);
    String nivel = calc.classificarConsumo(total, quantidade);
    double co2 = calc.calcularCO2(total, tipo);
    String tempo = calc.tempoDecomposicao(tipo);
    salvarHistorico(tipo, quantidade, total);
    String alertaMeta = "";
    if (meta > 0 && total > meta) {
        alertaMeta = "\n\nVoce ultrapassou sua meta!";
    }
    JOptionPane.showMessageDialog(null, "RESULTADO\n\nTipo: " + calc.obterNomeTipo(tipo) + "\nQuantidade: " + quantidade + "\nTotal: " + total + " kg\nNivel: " + nivel + "\nCO2: " + co2 + " kg\nTempo: " + tempo + "\n\n" + calc.gerarMensagem(nivel) + alertaMeta);
}
    // ================= SALVAR =================
    public static void salvarHistorico(int tipo, int quantidade, double total) {
        if (contador < 100) {
            tipos[contador] = calc.obterNomeTipo(tipo);
            quantidades[contador] = quantidade;
            consumos[contador] = total;
            contador++;
        }
    }
    // ================= HISTORICO =================
    public static void mostrarHistorico() {
        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum dado no historico.");
            return;
        }
        String texto = "HISTORICO\n\n";
        double soma = 0;
        for (int i = 0; i < contador; i++) {
            texto += "Registro " + (i + 1) + "\nTipo: " + tipos[i] + "\nQuantidade: " + quantidades[i] + "\nTotal: " + consumos[i] + " kg\n\n";
            soma += consumos[i];
        }
        double media = soma / contador;
        texto += "-----------------------\nTotal geral: " + soma + " kg\nMedia: " + media + " kg";
        JOptionPane.showMessageDialog(null, texto);
    }
    // ================= LIMPAR =================
    public static void limparHistorico() {
        contador = 0;
        JOptionPane.showMessageDialog(null, "Historico apagado com sucesso.");
    }
    // ================= META =================
    public static void definirMeta() {
        meta = Double.parseDouble(JOptionPane.showInputDialog("Digite sua meta (kg):"));
        JOptionPane.showMessageDialog(null, "Meta definida: " + meta + " kg");
    }

    // ================= INFO =================
    public static void mostrarInformacoes() {
        JOptionPane.showMessageDialog(null, "INFORMACOES\n\nO plastico demora muito tempo para desaparecer.\nEvite o uso excessivo.\n\nDicas:\n- Reduzir\n- Reutilizar\n- Reciclar");
    }
    // ================= SAIR =================
    public static void sair() {
        JOptionPane.showMessageDialog(null, "Programa encerrado.");
    }
}