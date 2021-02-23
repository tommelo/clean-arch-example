package com.itgorillaz.core.command.email.send.rule;

import java.util.ArrayList;
import java.util.List;

import com.itgorillaz.core.command.Rule;
import com.itgorillaz.core.command.RuleException;
import com.itgorillaz.core.command.email.send.SendEmailCommand;
import com.itgorillaz.core.command.email.send.SendEmailCommand.SendEmailAttachment;
import com.itgorillaz.core.command.email.send.SendEmailContext;
import com.itgorillaz.core.model.Email.EmailAttachment;
import com.itgorillaz.core.model.EmailRequestStatusCode;
import com.itgorillaz.core.service.FileDetails;
import com.itgorillaz.core.service.FileStorageService;

public class LoadAttachmentsRule implements Rule<SendEmailCommand, SendEmailContext> {

	private final int MAX_ATTACHMENT_SIZE_IN_MB = 10;
	
	private FileStorageService fileStorageService;
	
	public LoadAttachmentsRule(FileStorageService fileStorageService) {
		this.fileStorageService = fileStorageService;
	}
	
	@Override
	public void execute(SendEmailCommand command, SendEmailContext context) throws RuleException {
		List<EmailAttachment> attachments = new ArrayList<>();
				
		if (!command.getAttachments().isEmpty()) {
			int fileSizeSumInMB = 0;
			
			for (SendEmailAttachment attachment : command.getAttachments()) {
				FileDetails details = this.fileStorageService
					.getFileDetails(attachment.getDir(), attachment.getFilename())
					.orElseThrow(() -> new RuleException(EmailRequestStatusCode.ATTACHMENT_NOT_FOUND.toString(), attachment));
				
				fileSizeSumInMB += details.getFileSizeInMB();
				if (fileSizeSumInMB > MAX_ATTACHMENT_SIZE_IN_MB) {
					throw new RuleException(EmailRequestStatusCode.MAX_ATTACHMENT_SIZE_EXCEEDED.toString(), command.getAttachments());
				}
				
				String content = this.fileStorageService.getFileContents(attachment.getDir(), attachment.getFilename()).get();
				attachments.add(new EmailAttachment(attachment.getAttachAsFileName(), content));
			}
			
		}
		
		context.setAttachments(attachments);
	}

}
