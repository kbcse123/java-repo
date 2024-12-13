@import com.order.food.model.CartTotal
@import com.order.food.model.Item
@param java.util.List<Item> items
@param CartTotal cartTotal

<!-- Checkout Page Start -->
<div id="main-content">
    <div class="container-fluid py-5">
        <div class="container py-5">
            <h1 class="mb-4">Billing details</h1>
            <form action="#">
                <div class="row g-5">
                    <div class="col-md-12 col-lg-6 col-xl-7">
                        <div class="row">
                            <div class="col-md-12 col-lg-6">
                                <div class="form-item w-100">
                                    <label class="form-label my-3">First Name<sup>*</sup></label>
                                    <input type="text" class="form-control" required>
                                </div>
                            </div>
                            <div class="col-md-12 col-lg-6">
                                <div class="form-item w-100">
                                    <label class="form-label my-3">Last Name<sup>*</sup></label>
                                    <input type="text" class="form-control" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-item">
                            <label class="form-label my-3">Company Name<sup>*</sup></label>
                            <input type="text" class="form-control" required>
                        </div>
                        <div class="form-item">
                            <label class="form-label my-3">Address <sup>*</sup></label>
                            <input type="text" class="form-control" placeholder="House Number Street Name" required>
                        </div>
                        <div class="form-item">
                            <label class="form-label my-3">Town/City<sup>*</sup></label>
                            <input type="text" class="form-control" required>
                        </div>
                        <div class="form-item">
                            <label class="form-label my-3">Country<sup>*</sup></label>
                            <input type="text" class="form-control" required>
                        </div>
                        <div class="form-item">
                            <label class="form-label my-3">Postcode/Zip<sup>*</sup></label>
                            <input type="text" class="form-control" required>
                        </div>
                        <div class="form-item">
                            <label class="form-label my-3">Mobile<sup>*</sup></label>
                            <input type="tel" class="form-control" required>
                        </div>
                        <div class="form-item">
                            <label class="form-label my-3">Email Address<sup>*</sup></label>
                            <input type="email" class="form-control" required>
                        </div>
                        <div class="form-check my-3">
                            <input type="checkbox" class="form-check-input" id="Account-1" name="Accounts"
                                   value="Accounts">
                            <label class="form-check-label" for="Account-1">Create an account?</label>
                        </div>
                        <hr>
                        <div class="form-check my-3">
                            <input class="form-check-input" type="checkbox" id="Address-1" name="Address"
                                   value="Address">
                            <label class="form-check-label" for="Address-1">Ship to a different address?</label>
                        </div>
                        <div class="form-item">
                            <textarea name="text" class="form-control" spellcheck="false" cols="30" rows="11"
                                      placeholder="Oreder Notes (Optional)"></textarea>
                        </div>
                    </div>
                    <div class="col-md-12 col-lg-6 col-xl-5">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col">Products</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Total</th>
                                </tr>
                                </thead>
                                <tbody>

                                @for(Item item : items)
                                    @if(item.getQuantity() > 0)

                                        <tr class="align-items-center">
                                            <th scope="row">
                                                <div class="d-flex align-items-center">
                                                    <img src="${item.getImagePath()}" class="img-fluid rounded-circle"
                                                         style="width: 60px; height: 60px;" alt="">
                                                </div>
                                            </th>
                                            <td class="py-3">${item.getName()}</td>
                                            <td class="py-3">${item.getPrice()}</td>
                                            <td class="py-3">${item.getQuantity()}</td>
                                            <td class="py-3">${item.getTotal()}</td>
                                        </tr>

                                    @endif
                                @endfor

                                <tr style="border-style:none;border-color:white">
                                    <td class="py-3"></td>
                                </tr>
                                <tr class="align-items-center" style="border-style:none;border-color:white">
                                    <td></td>
                                    <td ></td>
                                    <td ></td>
                                    <td >
                                        <p class="mb-0 text-dark">SubTotal:</p>
                                    </td>
                                    <td >
                                        <div>
                                            <p class="mb-0 text-dark">${cartTotal.getSubTotal()}</p>
                                        </div>
                                    </td>
                                </tr>
                                <tr class="align-items-center" style="border-style:none;border-color:white">
                                    <td></td>
                                    <td ></td>
                                    <td ></td>
                                    <td >
                                        <p class="mb-0 text-dark">Delivery Fee:</p>
                                    </td>
                                    <td >
                                        <div >
                                            <p class="mb-0 text-dark">${cartTotal.getDeliveryFee()}</p>
                                        </div>
                                    </td>
                                </tr>
                                <tr class="align-items-center" >
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>
                                       <%-- <h4>Total</h4>--%>
                                        <p class="text-dark fw-bold">Total:</p>
                                    </td>
                                    <td>
                                        <div>
                                            <%--<h4 class="text-dark">Rs.${cartTotal.getTotal()}</h4>--%>
                                            <p class="text-dark fw-bold">${cartTotal.getTotal()}</p>
                                        </div>
                                    </td>
                                </tr>

                                </tbody>
                            </table>
                        </div>

                        <div class="row g-4 text-center align-items-center justify-content-center border-bottom">
                            <div class="col-12">
                                <div class="form-check text-start my-3">
                                    <input type="radio" id="payment1" name="payment" value="PhonePe" checked>
                                    <label for="payment1">PhonePe</label>
                                    <br>
                                    <input type="radio" id="payment2" name="payment" value="COD">
                                    <label for="payment2">Cash On Delivery</label>
                                    <br>
                                </div>
                            </div>
                        </div>

                        <div class="row g-4 text-center align-items-center justify-content-center pt-4">
                            <button type="button"
                                    class="btn border-secondary py-3 px-4 text-uppercase w-100 text-primary">Place Order
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Checkout Page End -->

