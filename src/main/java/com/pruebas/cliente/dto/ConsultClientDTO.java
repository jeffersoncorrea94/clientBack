package com.pruebas.cliente.dto;

import javax.validation.constraints.Pattern;

public class ConsultClientDTO {
    @Pattern(regexp = "^[CP]$", message = "{Pattern.consultClientDTO.tipoDocumento}")
    private String tipoDocumento;

    private String numeroDocumento;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
