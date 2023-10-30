package com.sierraazul.controlpagosapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "pagos")
@AllArgsConstructor
@NoArgsConstructor
public class PagosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String cut;
    private String fecha;
    private String tipoDocumento;
    private String nro;
    private String ftefto;
    private String monto;
    private String areaUsuaria;
    private String fechaRecepcion;

    private String nombreProveedor;
    private Integer orden; // compartido con conta
    private Integer siaf; // compartido con conta

    // Control previo
    private String clasificador;
    private String responsableControlPrevio;
    private String tipoOrdenServicioCompra;
    private String region;
    private String ruc;
    private String comprobante; // compartido con conta 
    private String nroDocumento;
    private String fechaEmision;
    private String penalidad;
    private String montoPenalidad;
    private String numeroPago;
    private String observacionPagos;
    private String estadoDocumento;
    private String fechaEntregaContabilidad;
    private String ultimaModificacion;
    private String fechaContabilidad_1;
    private String fechaContabilidad_2;
    private String estadoControlPrevio;
    private String responsableContabilidad;
    private String comprobanteContabilidad;
    private String montoContabilidad;
    private String retencionContabilidad;
    private String detraccionContabilidad;  
    private String penalidadContabilidad;
    private String situacionExpediente;

    private String porRevisar;
    private String estadoDevengadoSiaf;
    private String tipoObservacion;
    private String concepto;

    private String areaCorrige;
    private String fechaEntrega;
    private String fechaDevolucion;

    private String estadoValidacion;
    private String fechaDevengado;
    private String montoDevengadoAprobado;
    // verifica repeticion
    private String verificaRepeticion;
    private String validaSiaf;
    private String comprobantePagoTesoreria;
    private String montoTotalCps;
    private String observacion;
    private String ubicacion;       

}