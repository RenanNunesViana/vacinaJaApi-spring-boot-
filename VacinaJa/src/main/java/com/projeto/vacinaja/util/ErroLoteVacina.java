package com.projeto.vacinaja.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErroLoteVacina {

    static final String LOTE_VACINA_NAO_CADASTRADO = "O Lote %s não existe.";
    static final String NENHUM_LOTE_CADASTRADO = "Nenhum lote cadastro.";
    static final String LOTE_JA_CADASTRADO = "Lote %s já cadastrado.";

    public static ResponseEntity<CustomErrorType> erroLoteVacinaNaoCadastrada(long idLote){
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(ErroLoteVacina.LOTE_VACINA_NAO_CADASTRADO,idLote)), HttpStatus.NOT_FOUND);
    }
    public static ResponseEntity<CustomErrorType> erroNenhumLoteCadastrado(){
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(ErroLoteVacina.NENHUM_LOTE_CADASTRADO),HttpStatus.NOT_FOUND);
    }
    public static ResponseEntity<CustomErrorType> erroLoteJaCadastrado(long idLote){
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(ErroLoteVacina.LOTE_JA_CADASTRADO,idLote)),HttpStatus.CONFLICT);
    }
}
