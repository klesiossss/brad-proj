package com.teste.servicebrad.managers;

import br.com.araujo.hubpagamento.config.annotations.BradescoComponent;
import br.com.araujo.hubpagamento.exception.AwsSecretManagerException;
import br.com.araujo.hubpagamento.service.aws.SecretManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@BradescoComponent
public class SecretService {

    @Autowired
    private final SecretManagerService client;

    @Autowired
    public SecretService(SecretManagerService client) {
        this.client = client;
    }
    public String getSecret() {

        try {
            return client.getSecret("us-east-2", "bradesco-credenciais", "BRADESCO_CLIENT_ID");
        } catch (AwsSecretManagerException e) {
              throw new RuntimeException(e.getMessage());
        }

    }



    public String getSecret2() {

        try {
            return client.getSecret("us-east-2", "bradesco-credenciais", "BRADESCO_CLIENT_ID");
        } catch (AwsSecretManagerException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}
