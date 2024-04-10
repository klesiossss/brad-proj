package com.teste.servicebrad.managers;


import br.com.araujo.hubpagamento.config.annotations.BradescoComponent;
import br.com.araujo.hubpagamento.domain.request.location.LocationRequest;
import br.com.araujo.hubpagamento.domain.request.payment.BradescoImmediateChargeEmvRequest;
import br.com.araujo.hubpagamento.domain.request.webhook.BradescoWebHookRequest;
import br.com.araujo.hubpagamento.domain.response.location.LocationResponse;
import br.com.araujo.hubpagamento.domain.response.payment.BradescoImmediateChargeEmvResponse;
import br.com.araujo.hubpagamento.domain.response.webhook.BradescoWebHookResponse;
import br.com.araujo.hubpagamento.service.BradescoPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@BradescoComponent
public class BradescoServiceHost {

    @Autowired
    private final BradescoPaymentService client;

    @Autowired
    public BradescoServiceHost(BradescoPaymentService client) {
        this.client = client;
    }




    public Mono<BradescoImmediateChargeEmvResponse> createQRCode(BradescoImmediateChargeEmvRequest request){
        return client.createPayment(request);
    }


    public Mono<BradescoWebHookResponse> createWebhook(BradescoWebHookRequest request) {
        return client.createWebhook(request);
    }

    public Mono<LocationResponse> location(LocationRequest request) {
        return client.location(request);
    }
}
