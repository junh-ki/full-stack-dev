import React from 'react';
import axios from 'axios';

class CollectClinicals extends React.Component{

    state = {}

    componentDidMount() {
        axios.get('http://localhost:8080/clinicalservices/api/patients/'+this.props.match.params.patientId)
        .then(res=>{
            this.setState(res.data)
        })
    }

    render() {
        return(<div>
            <h2>Patient Details:</h2>
            First Name: {this.state.firstName}
            Last Name: {this.state.lastName}
            Age: {this.state.age}
            <form>
                
            </form>
        </div>)
    }
}

export default CollectClinicals;
