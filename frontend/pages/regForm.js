import React,{ useState } from 'react';
export default function Form() {
  
  // States for registration
  const [Firstname, setFirstName] = useState('');
  const [Lastname, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setconfirmPassword] = useState('');
  const [phoneNo, setPhoneNo] = useState('');

  // States for checking the errors
  const [submitted, setSubmitted] = useState(false);
  const [error, setError] = useState(false);
  
  // Handling the name change
  const handleFirstName = (e) => {
    setFirstName(e.target.value);
    setSubmitted(false);
  };
  
  const handleLastName = (e) => {
    setLastName(e.target.value);
    setSubmitted(false);
  };

  // Handling the email change
  const handleEmail = (e) => {
    setEmail(e.target.value);
    setSubmitted(false);
  };
  
  // Handling the password change
  const handlePassword = (e) => {
    setPassword(e.target.value);
    setSubmitted(false);
  };

  const handleconfirmPassword = (e) => {
    setconfirmPassword(e.target.value);
    setSubmitted(false);
  };
  
  // Handling the phoneNo change
  const handlePhoneNo = (e) => {
    setPhoneNo(e.target.value);
    setSubmitted(false);
  };
  // Handling the form submission
  const handleSubmit = (e) => {
    e.preventDefault();
    if (Firstname === '' || Lastname === '' || email === '' || password === ''|| confirmPassword === ''|| phoneNo === '' ) {
      setError(true);
      
    } else {
      setSubmitted(true);
      setError(false);
    }
  };
  
  // Showing success message
  const successMessage = () => {
    return (
      <div
        className="success"
        style={{
          display: submitted ? '' : 'none',
        }}>
        <h1>User {Firstname} {Lastname} successfully registered!!</h1>
      </div>
    );
  };
  
  // Showing error message if error is true
  const errorMessage = () => {
    return (
      <div
        className="error"
        style={{
          display: error ? '' : 'none',
        }}>
        <h1>Please enter all the fields</h1>
      </div>
    );
  };
  const errorMessage1 = () => {
    return (
      <div
        className="error2"
        style={{
          display: error ? '' : 'none',
        }}>
        <h1>Passwords do not match</h1>
      </div>
    );
  };

  
  
  return (
    <div className="form">
      <div>
        <h1>User Registration</h1>
      </div>
  
      {/* Calling to the methods */}
      <div className="messages">
        {errorMessage()}
        {successMessage()}
      </div>
  
      <form className='form'>
        {/* Labels and inputs for form data */}
        <label className="label">First Name</label>
        <input onChange={handleFirstName} className="input" 
          value={Firstname} type="text" />

        <label className="label">Last Name</label>
        <input onChange={handleLastName} className="input" 
          value={Lastname} type="text" />
  
        <label className="label">Email</label>
        <input onChange={handleEmail} className="input" 
          value={email} type="email" />
  
        <label className="label">Password</label>
        <input onChange={handlePassword} className="input" 
          value={password} type="password">
          </input>

        <label className="label">Confirm Password</label>
        <input onChange={handleconfirmPassword} className="input" 
          value={confirmPassword} type="password" />

        <label className="label">PhoneNo.</label>
        <input onChange={handlePhoneNo} className="input" 
          value={phoneNo} type="number" />
  
        <button onClick={handleSubmit} className="btn" type="submit">
          Register
        </button>
      </form>

    </div>
  );
}