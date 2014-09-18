/**
 * SmsSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _205._76._14._196;

public interface SmsSoap extends java.rmi.Remote {
    public _205._76._14._196.WebRetrieveMessagesResponseWebRetrieveMessagesResult webRetrieveMessages(java.lang.String userId, java.lang.String date_from, java.lang.String date_to, int readstart, int readend, java.lang.String order) throws java.rmi.RemoteException;
    public boolean webDeleteSent(java.lang.String userId, long id) throws java.rmi.RemoteException;
    public _205._76._14._196.WebRetrieveSentResponseWebRetrieveSentResult webRetrieveSent(java.lang.String userId, java.lang.String date_from, java.lang.String date_to, int readstart, int readend, java.lang.String order) throws java.rmi.RemoteException;
    public boolean webMoDelete(int id) throws java.rmi.RemoteException;
    public java.lang.String[] retrieveMessageStatuses(java.lang.String userId, java.lang.String messageId) throws java.rmi.RemoteException;
    public _205._76._14._196.RetrieveMessagesResponseRetrieveMessagesResult retrieveMessages(java.lang.String userId, int count) throws java.rmi.RemoteException;
    public long credits(java.lang.String user_id) throws java.rmi.RemoteException;
    public boolean send(java.lang.String recepient, java.lang.String short_message, java.lang.String message_id, java.lang.String dispatch_datetime, java.lang.String cutoff_datetime, java.lang.String user_id) throws java.rmi.RemoteException;
    public boolean sendLong(java.lang.String recepient, java.lang.String short_message, java.lang.String message_id, java.lang.String dispatch_datetime, java.lang.String cutoff_datetime, java.lang.String user_id) throws java.rmi.RemoteException;
    public java.lang.String ping() throws java.rmi.RemoteException;
    public boolean createScheduler(java.lang.String userId) throws java.rmi.RemoteException;
    public boolean writeToSchedule(java.lang.String userId, java.lang.String deadline, java.lang.String message, java.lang.String recepient) throws java.rmi.RemoteException;
    public _205._76._14._196.FetchScheduleResponseFetchScheduleResult fetchSchedule(java.lang.String userId) throws java.rmi.RemoteException;
    public boolean clearSchedule(java.lang.String userId) throws java.rmi.RemoteException;
    public boolean deleteScheduleItem(java.lang.String userId, java.lang.String id) throws java.rmi.RemoteException;
    public boolean createContactsFolder(java.lang.String userId) throws java.rmi.RemoteException;
    public boolean newContact(java.lang.String userId, java.lang.String name, java.lang.String surname, java.lang.String mobile, java.lang.String fax, java.lang.String tel, java.lang.String email, java.lang.String grouping) throws java.rmi.RemoteException;
    public boolean deleteContact(java.lang.String userId, java.lang.String id) throws java.rmi.RemoteException;
    public boolean updateContact(java.lang.String userId, java.lang.String id, java.lang.String name, java.lang.String surname, java.lang.String mobile, java.lang.String fax, java.lang.String tel, java.lang.String email, java.lang.String grouping) throws java.rmi.RemoteException;
    public _205._76._14._196.GetContactGroupsResponseGetContactGroupsResult getContactGroups(java.lang.String userId) throws java.rmi.RemoteException;
    public boolean updateContactGroup(java.lang.String userId, java.lang.String contactId, java.lang.String grouping) throws java.rmi.RemoteException;
    public _205._76._14._196.GetContactsResponseGetContactsResult getContacts(java.lang.String userId) throws java.rmi.RemoteException;
    public int countUnreadReceived(java.lang.String userId) throws java.rmi.RemoteException;
    public int countReadReceived(java.lang.String userId) throws java.rmi.RemoteException;
    public int countSent(java.lang.String userId) throws java.rmi.RemoteException;
    public java.lang.String[] fetchSCList(java.lang.String userId) throws java.rmi.RemoteException;
}
