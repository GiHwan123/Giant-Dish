import React, { Component } from "react";
import { Card, Button, Row } from "react-bootstrap";
class Cart extends Component {
  render() {
    const cart = JSON.parse(localStorage.getItem("cart"));
    return (
      <Row>
        <Card className="order">
          <Card.Header as="h5">주문표</Card.Header>
          <Card.Body>
            <Card.Text>
              {cart.map(item => (
                <div>
                  {item.name} {item.price}원 {item.count}{" "}
                </div>
              ))}
              <hr />
              <p>
                <b>총합: </b> 원
              </p>
            </Card.Text>
          </Card.Body>
          <Card.Footer>
            {" "}
            <Button variant="dark">주문하기</Button>
          </Card.Footer>
        </Card>
      </Row>
    );
  }
}

export default Cart;
