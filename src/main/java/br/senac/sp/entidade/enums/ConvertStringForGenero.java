package br.senac.sp.entidade.enums;

public abstract class ConvertStringForGenero {

    public static Genero parse(String genero){
        switch (genero){
            case "FEMININO":
                return Genero.FEMININO;
            case "MASCULINO":
                return Genero.MASCULINO;
            default:
                return null;
        }
    }

    public static String decode(Genero genero){
        switch (genero){
            case FEMININO:
                return  "FEMININO";
            case MASCULINO:
                return "MASCULINO";
            default:
                return null;
        }
    }
}
