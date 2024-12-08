
@import com.order.food.model.Item
@param java.util.List<Item> items

<div id="main-content">
    <div class="container-fluid fruite py-5">
        <div class="container py-5">

            <div class="text-center">
                <div class="row g-4">
                    <div class="col-lg-12">
                        <div class="row g-4">
                            <h2 class="mb-4">Veg</h2>
                            @for(Item item: items)

                                <div class="col-md-6 col-lg-4 col-xl-3">
                                    <div class="rounded position-relative fruite-item">
                                        <div class="fruite-img">
                                            <img src="${item.getImagePath()}" class="img-fluid w-100 rounded-top"
                                                 alt="${item.getName()}"
                                                 style="height:250px" loading="lazy">
                                        </div>
                                        <%--<div class="text-white bg-secondary px-3 py-1 rounded position-absolute" style="top: 10px; left: 10px;">Fruits</div>--%>
                                        <div class="p-4 border border-secondary border-top-0 rounded-bottom">
                                            <h4>${item.getName()}</h4>
                                            <%--<p>Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>--%>
                                            <div class="d-flex justify-content-between flex-lg-wrap">
                                                <%--<p class="text-dark fs-5 fw-bold mb-0"></p>--%>
                                                <div class="text-dark fs-5 fw-bold mt-4">${item.getCurrency()}${item.getPrice()}</div>
                                                <%--
                                                <a href="#" hx-post="/addToCart/${item.getId()}"
                                                   hx-target="#cartCounter"
                                                   class="btn border border-secondary rounded-pill px-3 text-primary"><i
                                                            class="fa fa-shopping-bag me-2 text-primary"></i>
                                                    Add to cart
                                                </a>
                                                --%>
                                                <div class="input-group quantity mt-4" style="width: 100px;">
                                                    <div class="input-group-btn">
                                                        <button hx-delete="/cart/${item.getId()}" hx-target="#cartCounter"
                                                                class="btn btn-sm btn-minus rounded-circle bg-light border">
                                                            <i class="fa fa-minus"></i>
                                                        </button>
                                                    </div>
                                                    <input  type="text" class="form-control form-control-sm text-center border-0"
                                                           value="${item.getQuantity()}" readonly>
                                                    <div class="input-group-btn">
                                                        <button hx-post="/cart/${item.getId()}" hx-target="#cartCounter"
                                                                class="btn btn-sm btn-plus rounded-circle bg-light border">
                                                            <i class="fa fa-plus"></i>
                                                        </button>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>

                            @endfor
                            <br/>
                            <br/>
                            <h2 class="mb-4">Non-Veg</h2>

                            <div class="col-md-6 col-lg-4 col-xl-3">
                                <div class="rounded position-relative fruite-item">
                                    <div class="fruite-img">
                                        <img src="img/khichdi-khatta-keema.webp" class="img-fluid w-100 rounded-top" alt="" style="height:250px" loading="lazy">
                                    </div>
                                    <%--<div class="text-white bg-secondary px-3 py-1 rounded position-absolute" style="top: 10px; left: 10px;">Fruits</div>--%>
                                    <div class="p-4 border border-secondary border-top-0 rounded-bottom">
                                        <h4>Khichdi Kheema</h4>
                                        <%--<p>Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>--%>
                                        <div class="d-flex justify-content-between flex-lg-wrap">
                                            <div class="text-dark fs-5 fw-bold mt-4">Rs. 100</div>
                                            <%--
                                            <a href="#" class="btn border border-secondary rounded-pill px-3 text-primary"><i class="fa fa-shopping-bag me-2 text-primary"></i> Add to cart</a>
                                            --%>
                                            <div class="input-group quantity mt-4" style="width: 100px;">
                                                <div class="input-group-btn">
                                                    <button class="btn btn-sm btn-minus rounded-circle bg-light border">
                                                        <i class="fa fa-minus"></i>
                                                    </button>
                                                </div>
                                                <input id="quantity" type="text" class="form-control form-control-sm text-center border-0"
                                                       value="0">
                                                <div class="input-group-btn">
                                                    <button class="btn btn-sm btn-plus rounded-circle bg-light border">
                                                        <i class="fa fa-plus"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>