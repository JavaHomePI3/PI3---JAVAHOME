package br.senac.sp.servlet.funcionario;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SenhaUtils {
    public static String criar(String senha){
        String retorno = "";
        MessageDigest md5 ;
        try{
            md5 = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1,md5.digest(senha.getBytes()));
            retorno = hash.toString(16);
        }catch (Exception e){
            System.out.println("Senha => Erro: " + e.getMessage());
        }

        return retorno;
    }
}
