import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import { Navbar } from './components';
import { Home, CalculatorPage } from './pages';

function App() {
  return (
    <Router>
      <Navbar></Navbar>

      <Switch>
        <Route exact path="/">
          <Home></Home>
        </Route>
        <Route exact path="/tax-calculator">
          <CalculatorPage></CalculatorPage>
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
