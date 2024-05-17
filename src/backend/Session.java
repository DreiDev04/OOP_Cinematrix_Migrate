
package backend;

public class Session {
    private String _username;
    private String _user_uid;

    public Session(){
        
    }
    public Session(String username, String user_uid){
        this._username = username;
        this._user_uid = user_uid;
    }
    public void setUsername(String username){
        _username = username;
    }
    
    public void setUserUID(String usere_uid){
        _user_uid = usere_uid;
    }
    public String getUserUID(){
        return _user_uid;
    }
    public String getUsername(){
        return _username;
        
    }

    
}
