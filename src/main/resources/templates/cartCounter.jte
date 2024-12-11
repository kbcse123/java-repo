@param int cartCount

<div id="cartCounter" class="d-flex m-3 me-0">
    <%--
     <button class="btn-search btn border border-secondary btn-md-square rounded-circle bg-white me-4" data-bs-toggle="modal" data-bs-target="#searchModal"><i class="fas fa-search text-primary"></i></button>
     --%>
    <a href="#" hx-get="/cart-content" hx-target="#main-content" hx-push-url="/cart" class="position-relative me-4 my-auto">
        <i class="fa fa-shopping-bag fa-2x"></i>
        <span class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1" style="top: -5px; left: 15px; height: 20px; min-width: 20px;">${cartCount}</span>
    </a>
    <a href="#" class="my-auto">
        <i class="fas fa-user fa-2x"></i>
    </a>
</div>