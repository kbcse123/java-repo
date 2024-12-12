@import com.order.food.model.Item
@import com.order.food.model.CartTotal
@param java.util.List<Item> items
@param CartTotal cartTotal
<!-- Cart Page Start -->
<div id="cart-content" class="container-fluid py-5">
    <div class="container py-5">
        <div class="row g-5">
            <div class="col-md-12 col-lg-6 col-xl-8">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Products</th>
                            <th scope="col">Name</th>
                            <th scope="col">Price</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Total</th>
                            <th scope="col">Handle</th>
                        </tr>
                        </thead>
                        <tbody id="foodItems">

                        @for(Item item : items)
                            @if(item.getQuantity() > 0)

                                <tr>
                                    <th scope="row">
                                        <div class="d-flex align-items-center">
                                            <img src="${item.getImagePath()}" class="img-fluid me-5 rounded-circle"
                                                 style="width: 80px; height: 80px;" alt="">
                                        </div>
                                    </th>
                                    <td>
                                        <p class="mb-0 mt-4">${item.getName()}</p>
                                    </td>
                                    <td>
                                        <p class="mb-0 mt-4">${item.getPrice()}</p>
                                    </td>
                                    <td>
                                        <div class="input-group quantity mt-4" style="width: 100px;">
                                            <div class="input-group-btn">
                                                <button hx-delete="/cart/${item.getId()}" hx-target="#cart-content, #cartCount"
                                                        hx-swap="outerHTML" hx-indicator="#spinner"
                                                        class="btn btn-sm btn-minus rounded-circle bg-light border" a>
                                                    <i class="fa fa-minus"></i>
                                                </button>
                                            </div>
                                            <input type="text" class="form-control form-control-sm text-center border-0"
                                                   value="${item.getQuantity()}" readonly>
                                            <div class="input-group-btn">
                                                <button hx-get="/cart/${item.getId()}" hx-target="#cart-content, #cartCount"
                                                        hx-swap="outerHTML" hx-indicator="#spinner"
                                                        class="btn btn-sm btn-plus rounded-circle bg-light border">
                                                    <i class="fa fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <p class="mb-0 mt-4">Rs.${item.getTotal()}</p>
                                    </td>
                                    <td>
                                        <button class="btn btn-md rounded-circle bg-light border mt-4">
                                            <i class="fa fa-times text-danger"></i>
                                        </button>
                                    </td>

                                </tr>

                            @endif
                        @endfor

                        </tbody>
                    </table>
                </div>
            </div>
            <%--<div class="mt-5">
                <input type="text" class="border-0 border-bottom rounded me-5 py-3 mb-4" placeholder="Coupon Code">
                <button class="btn border-secondary rounded-pill px-4 py-3 text-primary" type="button">Apply Coupon
                </button>
            </div>--%>
            <%--<div class="col-8"></div>--%>
            <div class="col-md-12 col-lg-6 col-xl-4 bg-light rounded">
                <div class="p-4">
                    <h1 class="display-6 mb-4">Cart <span class="fw-normal">Total</span></h1>
                    <div class="d-flex justify-content-between mb-4">
                        <h5 class="mb-0 me-4">Subtotal:</h5>
                        <p class="mb-0">Rs.${cartTotal.getSubTotal()}</p>
                    </div>
                    <div class="d-flex justify-content-between">
                        <h5 class="mb-0 me-4">Delivery Fee:</h5>
                        <div class="">
                            <p class="mb-0">Rs.${cartTotal.getDeliveryFee()}</p>
                        </div>
                    </div>
                    <%--<p class="mb-0 text-end">GST</p>--%>
                </div>
                <div class="py-4 mb-4 border-top border-bottom d-flex justify-content-between">
                    <h5 class="mb-0 ps-4 me-4">Total</h5>
                    <p class="mb-0 pe-4">Rs.${cartTotal.getTotal()}</p>
                </div>
                <%--<button hx class="btn border-secondary rounded-pill px-4 py-3 text-primary text-uppercase mb-4 ms-4"
                        type="button">Proceed Checkout
                </button>--%>
                <a href="/checkout" class="btn border-secondary rounded-pill px-4 py-3 text-primary text-uppercase mb-4 ms-4">Proceed to Checkout</a>
            </div>

        </div>
    </div>
</div>
<!-- Cart Page End -->
