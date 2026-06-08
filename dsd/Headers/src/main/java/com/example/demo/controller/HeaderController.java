package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/*
 * ==========================================================
 * HeaderController
 * ==========================================================
 *
 * Exemplo didático para estudo de cabeçalhos HTTP
 *
 * Objetivos:
 *
 * 1) Ler cabeçalhos enviados pelo navegador
 * 2) Enviar cabeçalhos para o navegador
 * 3) Demonstrar cache
 * 4) Demonstrar download
 * 5) Demonstrar autenticação
 * 6) Demonstrar segurança
 * 7) Demonstrar CORS
 *
 * ==========================================================
 */

@RestController
public class HeaderController {

    /*
     * ======================================================
     * EXEMPLO 1
     * Ler User-Agent
     * ======================================================
     *
     * User-Agent identifica navegador e sistema operacional.
     *
     * Exemplos:
     *
     * Chrome
     * Firefox
     * Edge
     * Safari
     *
     */
    @GetMapping("/headers/user-agent")
    public String userAgent(
            @RequestHeader("User-Agent") String userAgent) {

        return "User-Agent recebido:\n\n" + userAgent;
    }

    /*
     * ======================================================
     * EXEMPLO 2
     * Ler idioma preferido
     * ======================================================
     *
     * Accept-Language
     *
     * Informa idioma preferido pelo navegador.
     *
     * Exemplo:
     *
     * pt-BR
     * en-US
     * es-ES
     *
     */
    @GetMapping("/headers/language")
    public String language(
            @RequestHeader("Accept-Language") String language) {

        return "Idioma informado: " + language;
    }

    /*
     * ======================================================
     * EXEMPLO 3
     * Ler Host
     * ======================================================
     *
     * Host informa qual domínio foi acessado.
     *
     * Exemplo:
     *
     * localhost:8080
     *
     */
    @GetMapping("/headers/host")
    public String host(
            @RequestHeader("Host") String host) {

        return "Host: " + host;
    }

    /*
     * ======================================================
     * EXEMPLO 4
     * Ler todos os cabeçalhos
     * ======================================================
     *
     * HttpHeaders reúne todos os cabeçalhos recebidos.
     *
     */
    @GetMapping("/headers/todos")
    public HttpHeaders todos(
            @RequestHeader HttpHeaders headers) {

        return headers;
    }

    /*
     * ======================================================
     * EXEMPLO 5
     * Enviar cabeçalho customizado
     * ======================================================
     *
     * Muito usado em APIs REST.
     *
     */
    @GetMapping("/headers/custom")
    public ResponseEntity<String> customHeader() {

        return ResponseEntity
                .ok()
                .header("X-Sistema", "Aula Spring MVC")
                .header("X-Versao", "1.0")
                .body("Cabeçalhos enviados.");
    }

    /*
     * ======================================================
     * EXEMPLO 6
     * Controle de Cache
     * ======================================================
     *
     * Cache-Control
     *
     * Informa por quanto tempo o navegador pode reutilizar
     * uma resposta sem consultar o servidor.
     *
     */
    @GetMapping("/headers/cache")
    public ResponseEntity<String> cache() {

        return ResponseEntity
                .ok()
                .header("Cache-Control", "max-age=60")
                .body("Pode ser armazenado por 60 segundos.");
    }

    /*
     * ======================================================
     * EXEMPLO 7
     * Sem cache
     * ======================================================
     *
     * Muito comum em sistemas financeiros.
     *
     */
    @GetMapping("/headers/no-cache")
    public ResponseEntity<String> noCache() {

        return ResponseEntity
                .ok()
                .header("Cache-Control",
                        "no-cache, no-store, must-revalidate")
                .body("Não armazenar.");
    }

    /*
     * ======================================================
     * EXEMPLO 8
     * Download de arquivo
     * ======================================================
     *
     * Content-Disposition
     *
     * Solicita download ao navegador.
     *
     */
    @GetMapping("/headers/download")
    public ResponseEntity<String> download() {

        return ResponseEntity
                .ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=relatorio.txt")
                .body("Conteúdo do relatório.");
    }

    /*
     * ======================================================
     * EXEMPLO 9
     * Tipo do conteúdo
     * ======================================================
     *
     * Content-Type
     *
     * Informa o formato dos dados.
     *
     */
    @GetMapping("/headers/json")
    public ResponseEntity<String> json() {

        return ResponseEntity
                .ok()
                .header(
                        HttpHeaders.CONTENT_TYPE,
                        "application/json")
                .body("""
                        {
                          "status":"ok"
                        }
                        """);
    }

    /*
     * ======================================================
     * EXEMPLO 10
     * Data/Hora do servidor
     * ======================================================
     *
     * Cabeçalho customizado.
     *
     */
    @GetMapping("/headers/data")
    public ResponseEntity<String> dataServidor() {

        return ResponseEntity
                .ok()
                .header(
                        "X-Data-Servidor",
                        LocalDateTime.now().toString())
                .body("Data enviada.");
    }

    /*
     * ======================================================
     * EXEMPLO 11
     * Autorização
     * ======================================================
     *
     * Authorization
     *
     * Muito usado em:
     *
     * Basic Auth
     * JWT
     * OAuth2
     *
     */
    @GetMapping("/headers/auth")
    public String auth(
            @RequestHeader(
                    value = "Authorization",
                    required = false)
            String authorization) {

        if (authorization == null) {
            return "Nenhum token enviado.";
        }

        return "Authorization: " + authorization;
    }

    /*
     * ======================================================
     * EXEMPLO 12
     * Origin
     * ======================================================
     *
     * Utilizado pelo CORS.
     *
     */
    @GetMapping("/headers/origin")
    public String origin(
            @RequestHeader(
                    value = "Origin",
                    required = false)
            String origin) {

        return "Origin: " + origin;
    }

    /*
     * ======================================================
     * EXEMPLO 13
     * Segurança
     * ======================================================
     *
     * X-Frame-Options
     *
     * Evita clickjacking.
     *
     */
    @GetMapping("/headers/security")
    public ResponseEntity<String> security() {

        return ResponseEntity
                .ok()
                .header("X-Frame-Options", "DENY")
                .header("X-Content-Type-Options", "nosniff")
                .body("Cabeçalhos de segurança enviados.");
    }

}