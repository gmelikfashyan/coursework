document.getElementById("let-register").addEventListener("click", function(event) {
    event.preventDefault();
    document.getElementById("enterForm").style.display = "none";
    document.getElementById("registration-form").style.display = "flex";
});

document.getElementById("let-enter").addEventListener("click", function(event) {
    event.preventDefault();
    document.getElementById("enterForm").style.display = "flex";
    document.getElementById("registration-form").style.display = "none";
});

function verifyDisplay() {
    var password = document.getElementById('password');
    var verify = document.getElementById('verify-password');

    if (password.value) {
        verify.style.display = 'block';
    } else {
        verify.style.display = 'none';
    }
}


function verifyPas() {
    var password = document.getElementById('password');
    var verify = document.getElementById('verify-password');

    if (password.value == verify.value) {
        var form = document.getElementById("registration-form");
        form.submit();
    } else {
        var error = document.getElementById("error");
        error.style.display = 'block';
    }
}

function letEnter() {
    document.getElementById('email').value = '';
    document.getElementById('password').value = '';
    document.getElementById('username').value = '';
    document.getElementById('userSurname').value = '';
    document.getElementById('verify-password').style.display='none';
    document.getElementById('verify-password').value = '';
}

function letRegister() {
    document.getElementById('loginUsername').value = '';
    document.getElementById('loginPassword').value = '';
}
function addBasket(id)
{
    let productImg = document.getElementById("img" + id);
    let SourceImg = productImg.getAttribute("src");
    let SourceImgString = String(SourceImg);
    let productPrice = document.getElementById("info" + id).innerText;
    let productBrand = document.getElementById("brand" + id).innerText;
    let productName = document.getElementById("title" + id).innerText;
    productPrice = parseInt(productPrice.replaceAll(' ', '').slice(0, -4));
    let item = {
        id: id,
        img: SourceImgString,
        name: productName,
        price: productPrice,
        brand: productBrand,
    };
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    let existingItem = cart.find(cartItem => cartItem.name === item.name);

    cart.push(item);
    localStorage.setItem('cart', JSON.stringify(cart));
}

var butArrange = document.getElementById("arrangeBut");



function fillBasket()
{
    let cartElems = document.getElementById("cartElems");
    cartElems.innerHTML = "";
    let sum = 0;
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    if (cart.length == 0){
        butArrange.addEventListener("click", function(event)
        {
            event.preventDefault();
        });
    } else {
        butArrange.addEventListener("click", function(event) {
            deleteAllElem();
        });

    }
    for (let i = 0; i < cart.length; i++) {
        let elem = document.createElement('div');
        elem.classList.add('oneProduct');
        elem.innerHTML = `
            <div class="card">
                <img src="${cart[i].img}" alt="${cart[i].name}">
                <div class="name-wrapper">
                    <p class="card-brand">${cart[i].brand}</p>
                    <p class="card-name">${cart[i].name}</p>
                </div>
            </div>
            <p>${cart[i].price} ₽</p>
            <div class = "removeAndPrice">
                <button class="deleteBut" onclick="deleteElem(${i})"></button>
            </div>`;
        let indexProduct = document.getElementById('index' + i);
        let nameProduct = document.getElementById('name' + i);
        let brandProduct = document.getElementById('brand' + i);
        let priceProduct = document.getElementById('productPrice' + i);
        indexProduct.value = parseInt(cart[i].id);
        nameProduct.value = cart[i].name;
        brandProduct.value = cart[i].brand;
        priceProduct.value = parseInt(cart[i].price);
        sum += cart[i].price;
        cartElems.appendChild(elem);
    }
    let totalSum = document.getElementById(`totalSum`);
    totalSum.value = parseInt(totalSum.value | 0) + sum;
}

function deleteElem(index)
{
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    cart.splice(index, 1);
    localStorage.setItem('cart', JSON.stringify(cart));
    submitForm();
    fillBasket();
}

function deleteAllElem()
{
    localStorage.removeItem('cart');
    window.location.href = 'account';
}

function getAmount() {
    let cart = JSON.parse(localStorage.getItem('cart')) || [];
    let input = document.getElementById('inputItems');
    input.value = parseInt(cart.length);
}


function submitForm() {
    getAmount();
    var form = document.getElementById("myForm");
    form.submit();
}