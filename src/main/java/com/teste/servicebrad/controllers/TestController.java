package com.teste.servicebrad.controllers;


import br.com.araujo.hubpagamento.domain.request.location.LocationRequest;
import br.com.araujo.hubpagamento.domain.request.payment.BradescoImmediateChargeEmvRequest;
import br.com.araujo.hubpagamento.domain.request.webhook.BradescoWebHookRequest;
import br.com.araujo.hubpagamento.domain.response.location.LocationResponse;
import br.com.araujo.hubpagamento.domain.response.payment.BradescoImmediateChargeEmvResponse;
import br.com.araujo.hubpagamento.domain.response.webhook.BradescoWebHookResponse;
import br.com.araujo.hubpagamento.service.aws.SecretManagerService;
import com.teste.servicebrad.managers.BradescoServiceHost;
import com.teste.servicebrad.managers.SecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("v1")
public class TestController {

  @Autowired
  private BradescoServiceHost bradescoServiceHost;

  @Autowired
  private SecretService secretService;


  public TestController(BradescoServiceHost bradescoServiceHost,SecretService secretService,SecretManagerService secretManagerService) {
    this.bradescoServiceHost = bradescoServiceHost;
    this.secretService=secretService;
  }



  @PostMapping("/test")
  public ResponseEntity<Mono<BradescoImmediateChargeEmvResponse>> pagamento(@RequestBody BradescoImmediateChargeEmvRequest request) {
    //return  ResponseEntity.ok(bradescoServiceHost.callLib2());
    //return  ResponseEntity.ok(service.callLib());
    String txId = UUID.randomUUID().toString();
    request.setTxId(txId);
     return ResponseEntity.ok(bradescoServiceHost.createQRCode(request));

  }





  @PostMapping("/cadastraWebhook")
  public ResponseEntity<Mono<BradescoWebHookResponse>> cadastraWebhook(@RequestBody BradescoWebHookRequest request) {
    //return  ResponseEntity.ok(bradescoServiceHost.callLib2());
    //return  ResponseEntity.ok(service.callLib());

    return ResponseEntity.ok(bradescoServiceHost.createWebhook(request));

  }

  @PostMapping("/location")
  public ResponseEntity<LocationResponse> location(@RequestBody LocationRequest request) {
    return ResponseEntity.ok(bradescoServiceHost.location(request).block());
  }

  @GetMapping("/location")
  public ResponseEntity<String> hello() {
    return ResponseEntity.ok("bradescoServiceHost.location(request)");
  }



/*
  @PostMapping("/canal2")
  public ResponseEntity<String> pagamento(@RequestBody Pagamento pagamento){
    // pagamentoService.publicarPagamento(pagamento);
    return ResponseEntity.ok("Message sent");
  }


  @PostMapping("/canal5")
  public ResponseEntity<String> pagamentoCanal5(@RequestBody PaymentDTO pagamento){
     serviceJson.publicarPagamento(pagamento);
    return ResponseEntity.ok("Message sent");
  }

  @PostMapping("/payment")
  public ResponseEntity<String> pagamentoCanal5(@RequestBody Payment pagamento){
    var response = service.senderSettings(pagamento);
    return ResponseEntity.ok(response);
  }*/
}
