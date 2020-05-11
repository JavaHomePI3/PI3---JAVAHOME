package br.senac.sp.entidade.enums;

/**
 *
 * @author joao.lucas
 */
public abstract class ConvertStringForDepartamento {
    public static Departamento parse(String departamento){
        switch (departamento){
            case "ADM":
                return Departamento.ADM;
            case "VENDAS":
                return Departamento.VENDAS;
            case "BACKOFFICE":
                return Departamento.BACKOFFICE;
            case "TI":
                return Departamento.TI;
            default:
                return null;
        }
    }
}
