package javaapplication1;

public class CalculadoraConsumo {

    public double obterConsumoPadrao(int tipo) {

        if (tipo == 1) {
            return 0.005;
        } else if (tipo == 2) {
            return 0.02;
        } else if (tipo == 3) {
            return 0.1;
        } else {
            return 0.05;
        }
    }
    public String obterNomeTipo(int tipo) {
        if (tipo == 1) {
            return "Sacola plastica";
        } else if (tipo == 2) {
            return "Garrafa PET";
        } else if (tipo == 3) {
            return "Embalagem plastica";
        } else {
            return "Desconhecido";
        }
    }
    public double calcularConsumoTotal(int quantidade, double consumoUnitario) {
        return quantidade * consumoUnitario;
    }
    public String classificarConsumo(double consumoTotal, int quantidade) {
    if (consumoTotal <= 2 && quantidade < 25) {
        return "BAIXO";
    } else if (consumoTotal <= 10 && quantidade < 70) {
        return "MEDIO";
    } else {
        return "ALTO";
    }
}

    public String gerarMensagem(String nivel) {

    if (nivel.equals("BAIXO")) {
        return "Voce esta usando pouco plastico. Continue assim e mantenha esse cuidado.";
    } else if (nivel.equals("MEDIO")) {
        return "Voce pode tentar diminuir um pouco o uso de plastico. Evite desperdicios e reutilize sempre que possivel.";
    } else {
        return "Voce esta consumindo plastico em altas quantidades. Recomendacoes: - Evite produtos descartaveis - Reutilize embalagens - Prefira materiais reciclaveis - Compre apenas o necessario - Utilize sacolas reutilizaveis";
    }
}
    public double calcularCO2(double consumoTotal, int tipo) {
    double fatorEmissao;
    switch (tipo) {
        case 1: 
            //sacola plastica
            //para calcular fator emissao foi levado como base que seus principais compostos são polietileno
            fatorEmissao = 5.5;
            break;
        case 2: 
            //garrafa plastica
            fatorEmissao = 6.0;
            break;
        case 3: 
            // embalagem plastica
            // para calcular o fator emissao foi levado como base que seus principais compostos são mistos
            fatorEmissao = 5.8;
            break;
        default:
            fatorEmissao = 5.6;
    }

    return consumoTotal * fatorEmissao;
}
    public String tempoDecomposicao(int tipo) {
    switch (tipo) {
        case 1:
            return "Sacolas plasticas podem levar de 10 a 20 anos para se decompor na natureza.";
        case 2:
            return "Garrafas PET podem levar cerca de 400 a 600 anos para se decompor.";
        case 3:
            return "Embalagens plasticas variam, mas geralmente levam mais de 100 anos para desaparecer.";
        default:
            return "Tempo de decomposicao desconhecido para este tipo de material.";
    }
}
}