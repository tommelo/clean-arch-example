package com.itgorillaz.core.command.email.send.rule;

import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.itgorillaz.core.command.Rule;
import com.itgorillaz.core.command.RuleException;
import com.itgorillaz.core.command.email.send.SendEmailCommand;
import com.itgorillaz.core.command.email.send.SendEmailContext;
import com.itgorillaz.core.model.EmailRequestStatusCode;

public class ValidateCommandRule implements Rule<SendEmailCommand, SendEmailContext> {

    @Override
    public void execute(SendEmailCommand command, SendEmailContext context) throws RuleException {
        Optional<Set<ConstraintViolation<Object>>> optional = command.validate();
        if (optional.isPresent()) {
            throw new RuleException(EmailRequestStatusCode.INVALID_PAYLOAD.toString(), optional.get());
        }
    }

}
