package br.senac.sp.entidade.enums;

public abstract class ConvertStringForUf {

    public static Uf parse(String uf) {
        switch (uf) {
            case "AC":
                return Uf.AC;
            case "AL":
                return Uf.AL;
            case "AM":
                return Uf.AM;
            case "AP":
                return Uf.AP;
            case "BA":
                return Uf.BA;
            case "CE":
                return Uf.CE;
            case "DF":
                return Uf.DF;
            case "ES":
                return Uf.ES;
            case "GO":
                return Uf.GO;
            case "MA":
                return Uf.MA;
            case "MG":
                return Uf.MG;
            case "MS":
                return Uf.MS;
            case "MT":
                return Uf.MT;
            case "PA":
                return Uf.PA;
            case "PB":
                return Uf.PB;
            case "PE":
                return Uf.PE;
            case "PI":
                return Uf.PI;
            case "PR":
                return Uf.PR;
            case "RJ":
                return Uf.RJ;
            case "RN":
                return Uf.RN;
            case "RO":
                return Uf.RO;
            case "RR":
                return Uf.RR;
            case "RS":
                return Uf.RS;
            case "SC":
                return Uf.SC;
            case "SE":
                return Uf.SE;
            case "SP":
                return Uf.SP;
            case "TO":
                return Uf.TO;
            default:
                return null;
        }
    }
}
