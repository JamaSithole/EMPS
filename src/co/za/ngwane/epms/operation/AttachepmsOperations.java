package co.za.ngwane.epms.operation;

import java.util.List;
import java.util.logging.Logger;

import co.za.ngwane.epms.dao.AttachepmsDAO;
import co.za.ngwane.epms.repository.Attachepms;
import co.za.ngwane.epms.repository.Ndp;
import co.za.ngwane.epms.repository.Progndplink;
import co.za.ngwane.epms.repository.Progtbl;
import co.za.ngwane.epms.repository.Projtbl;
import co.za.ngwane.epms.repository.Qoupd;
import co.za.ngwane.epms.serviceImpl.AttachepmsServiceImpl;
import co.za.ngwane.epms.serviceImpl.ProgNdpLinkServiceImpl;
import co.za.ngwane.epms.serviceImpl.ProjectServiceImpl;

public class AttachepmsOperations {
	
	
	private static Logger logger = Logger.getLogger("co.za.ngwane.epms.operation.AttachepmsOperations");
	
	public boolean uploadPoe(List<Attachepms> attachList, Qoupd qoupd){  

		boolean results = true;
		logger.info("Adding Attachment for Output Ref : "+qoupd.getOutputtblid().getRefno());

		if(qoupd != null && !attachList.isEmpty()){
			for (Attachepms attachepms : attachList) { 
				try {
					attachepms.setQoupdid(qoupd);
					attachepms.setAttachment(attachepms.getAttachment());
					attachepms.setName(attachepms.getName());
					
					new AttachepmsServiceImpl().add(attachepms);
					
					logger.info("Attachment Object added for Output Ref : " + qoupd.getOutputtblid().getRefno());
				} catch (Exception e) {
					logger.info("Failed to add Object added for Output Ref : " + qoupd.getOutputtblid().getRefno());
					results = false;
					e.printStackTrace();
				}
			}
		}

		return results;
	} 
	
	public List<Attachepms> getByQoupd(Qoupd qoupd) throws Exception {
		List<Attachepms> attachList =  null;
		
		if(qoupd != null){
			attachList = new AttachepmsDAO().getByQoupd(qoupd);				
		}		
		return attachList;
	}

}
