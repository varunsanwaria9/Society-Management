import { useState } from 'react';
import BasicApi from '../services/BasicApi'

export default function Form() {
  
  // States for login
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  
  // States for checking the errors
  const [errorMessage,setErrorMessage] = useState('Invalid Password')
  const [showError,setShowError] = useState(false)

  // Handling the email change
  const handleEmail = (e) => {
    setEmail(e.target.value);
  };
  
  const handlePassword = (e) => {
    setPassword(e.target.value);
  };

  
  const handleLogin = (event) => {
    event.preventDefault();
    BasicApi.login({email,password})
        .then(res => {
            if(res.status === 200){
                console.log(res.data);
                setShowError(true)
                setErrorMessage("Login Successful")
            }
            else{
                setShowError(true)
                setErrorMessage("Unknown Error Occured")
            }
        })
}
  
  return (
    <div className="form">
      <div>
        <h1>User Login</h1>
      </div>
  
      {showError && <div className="messages">
        {errorMessage}
      </div>}
  
      <form>
        <label className="label">Email</label>
        <input onChange={handleEmail} className="input" 
          value={email} type="email" />
  
        <label className="label">Password</label>
        <input onChange={handlePassword} className="input" 
          value={password} type="password" />
  
        <button onClick={handleLogin} className="btn" type="submit">
          Submit
        </button>
      </form>
    </div>
  );
}