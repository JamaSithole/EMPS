package _205._76._14._196;

public class SmsSoapProxy implements _205._76._14._196.SmsSoap {
  private String _endpoint = null;
  private _205._76._14._196.SmsSoap smsSoap = null;
  
  public SmsSoapProxy() {
    _initSmsSoapProxy();
  }
  
  public SmsSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initSmsSoapProxy();
  }
  
  private void _initSmsSoapProxy() {
    try {
      smsSoap = (new _205._76._14._196.SmsLocator()).getsmsSoap();
      if (smsSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)smsSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)smsSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (smsSoap != null)
      ((javax.xml.rpc.Stub)smsSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public _205._76._14._196.SmsSoap getSmsSoap() {
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap;
  }
  
  public _205._76._14._196.WebRetrieveMessagesResponseWebRetrieveMessagesResult webRetrieveMessages(java.lang.String userId, java.lang.String date_from, java.lang.String date_to, int readstart, int readend, java.lang.String order) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.webRetrieveMessages(userId, date_from, date_to, readstart, readend, order);
  }
  
  public boolean webDeleteSent(java.lang.String userId, long id) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.webDeleteSent(userId, id);
  }
  
  public _205._76._14._196.WebRetrieveSentResponseWebRetrieveSentResult webRetrieveSent(java.lang.String userId, java.lang.String date_from, java.lang.String date_to, int readstart, int readend, java.lang.String order) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.webRetrieveSent(userId, date_from, date_to, readstart, readend, order);
  }
  
  public boolean webMoDelete(int id) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.webMoDelete(id);
  }
  
  public java.lang.String[] retrieveMessageStatuses(java.lang.String userId, java.lang.String messageId) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.retrieveMessageStatuses(userId, messageId);
  }
  
  public _205._76._14._196.RetrieveMessagesResponseRetrieveMessagesResult retrieveMessages(java.lang.String userId, int count) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.retrieveMessages(userId, count);
  }
  
  public long credits(java.lang.String user_id) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.credits(user_id);
  }
  
  public boolean send(java.lang.String recepient, java.lang.String short_message, java.lang.String message_id, java.lang.String dispatch_datetime, java.lang.String cutoff_datetime, java.lang.String user_id) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.send(recepient, short_message, message_id, dispatch_datetime, cutoff_datetime, user_id);
  }
  
  public boolean sendLong(java.lang.String recepient, java.lang.String short_message, java.lang.String message_id, java.lang.String dispatch_datetime, java.lang.String cutoff_datetime, java.lang.String user_id) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.sendLong(recepient, short_message, message_id, dispatch_datetime, cutoff_datetime, user_id);
  }
  
  public java.lang.String ping() throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.ping();
  }
  
  public boolean createScheduler(java.lang.String userId) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.createScheduler(userId);
  }
  
  public boolean writeToSchedule(java.lang.String userId, java.lang.String deadline, java.lang.String message, java.lang.String recepient) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.writeToSchedule(userId, deadline, message, recepient);
  }
  
  public _205._76._14._196.FetchScheduleResponseFetchScheduleResult fetchSchedule(java.lang.String userId) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.fetchSchedule(userId);
  }
  
  public boolean clearSchedule(java.lang.String userId) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.clearSchedule(userId);
  }
  
  public boolean deleteScheduleItem(java.lang.String userId, java.lang.String id) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.deleteScheduleItem(userId, id);
  }
  
  public boolean createContactsFolder(java.lang.String userId) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.createContactsFolder(userId);
  }
  
  public boolean newContact(java.lang.String userId, java.lang.String name, java.lang.String surname, java.lang.String mobile, java.lang.String fax, java.lang.String tel, java.lang.String email, java.lang.String grouping) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.newContact(userId, name, surname, mobile, fax, tel, email, grouping);
  }
  
  public boolean deleteContact(java.lang.String userId, java.lang.String id) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.deleteContact(userId, id);
  }
  
  public boolean updateContact(java.lang.String userId, java.lang.String id, java.lang.String name, java.lang.String surname, java.lang.String mobile, java.lang.String fax, java.lang.String tel, java.lang.String email, java.lang.String grouping) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.updateContact(userId, id, name, surname, mobile, fax, tel, email, grouping);
  }
  
  public _205._76._14._196.GetContactGroupsResponseGetContactGroupsResult getContactGroups(java.lang.String userId) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.getContactGroups(userId);
  }
  
  public boolean updateContactGroup(java.lang.String userId, java.lang.String contactId, java.lang.String grouping) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.updateContactGroup(userId, contactId, grouping);
  }
  
  public _205._76._14._196.GetContactsResponseGetContactsResult getContacts(java.lang.String userId) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.getContacts(userId);
  }
  
  public int countUnreadReceived(java.lang.String userId) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.countUnreadReceived(userId);
  }
  
  public int countReadReceived(java.lang.String userId) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.countReadReceived(userId);
  }
  
  public int countSent(java.lang.String userId) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.countSent(userId);
  }
  
  public java.lang.String[] fetchSCList(java.lang.String userId) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.fetchSCList(userId);
  }
  
  
}