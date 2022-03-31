let navbar = document.querySelector('.header .navbar');

document.querySelector('#menu-btn').onclick = () =>{
    navbar.classList.toggle('active');
}

window.onscroll = () =>{
    navbar.classList.remove('active');
}

$(document).ready(function(){
    $(window).scroll(function(){
        $(".teachersani").each(function(){
            const pos = $(this).offset().top;
            const winTop = $(window).scrollTop();
            if (pos < winTop + 600) {
                $(this).addClass("slide");
            }
        })
    })
})


// ========================================hiện thị sản phẩn===============================================
const product = [
    { id: 1, image: "http://static.ybox.vn/2017/5/12/1041f8a2-368f-11e7-8a7e-cac091044fd5.jpg", title: "1: Charlotte’s Web - E.B White" },
    { id: 2, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFWJqC2-oWjd4Y41dYAwgYohlTFsWxdVmMwKI1_bCG9TMXDAJKxA&s", title: "2: Meiko and the Fifth Treasure" },
    { id: 3, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFWJqC2-oWjd4Y41dYAwgYohlTFsWxdVmMwKI1_bCG9TMXDAJKxA&s", title: "3: The Outsiders" },
    { id: 4, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-qQB5yclfLwCxqLRpD9tY_jhDg0PVIDQl-IO03nXZUi5hDDTpDQ&s", title: "4: The House on Mango Street" },
    { id: 5, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9cgZnVmMMj0Eb1An2Mujhbhs0ZVc5EhhY5NPhxuFyBz--M1jkWg&s", title: "5: Thirteen Reasons Why" },
    { id: 6, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpDmlqUatqqQMgLj_gDhRX_hSRRvNXVjrgfJLEn5VNSpF40HBp&s", title: "6: Peter Pan" },
    { id: 7, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPy6hIPkdydn_GJQ7hFqBnsPSLtNNemFGazeoquHN5czXyyIu2&s", title: "7: The Old Man and the Sea" },
    { id: 8, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpDmlqUatqqQMgLj_gDhRX_hSRRvNXVjrgfJLEn5VNSpF40HBp&s", title: "8: Ernest Hemmingway" },
    { id: 9, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLvXgwoxPYiT81oxvnETd_06GEcqgLBnusANy1IbVOdtUgD3Rd&s", title: "9: The Giver - Lois Lowry" },
    { id: 10, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8K9mxh-_NQEZkbeKEXl5vdKiy8nHT7zVhIL8TASmLKTbOKO0tgA&s", title: "10: Number the Stars - Lois Lowry" },
    { id: 11, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFWJqC2-oWjd4Y41dYAwgYohlTFsWxdVmMwKI1_bCG9TMXDAJKxA&s", title: "11: A Wrinkle In Time - Madeleine L’engle" },
    { id: 12, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFWJqC2-oWjd4Y41dYAwgYohlTFsWxdVmMwKI1_bCG9TMXDAJKxA&s", title: "12: Silence Once Begun" },
    { id: 13, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8K9mxh-_NQEZkbeKEXl5vdKiy8nHT7zVhIL8TASmLKTbOKO0tgA&s", title: "13: Sleep Donation" },
    { id: 14, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFWJqC2-oWjd4Y41dYAwgYohlTFsWxdVmMwKI1_bCG9TMXDAJKxA&s", title: "14: Can’t and Won’t" },
    { id: 15, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFWJqC2-oWjd4Y41dYAwgYohlTFsWxdVmMwKI1_bCG9TMXDAJKxA&s", title: "15: The News: A User’s Manual" },
    { id: 16, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8K9mxh-_NQEZkbeKEXl5vdKiy8nHT7zVhIL8TASmLKTbOKO0tgA&s", title: "16: Every Day Is for the Thief" },
    { id: 17, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFWJqC2-oWjd4Y41dYAwgYohlTFsWxdVmMwKI1_bCG9TMXDAJKxA&s", title: "17: The UnAmericans" },
    { id: 18, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFWJqC2-oWjd4Y41dYAwgYohlTFsWxdVmMwKI1_bCG9TMXDAJKxA&s", title: "18: Kinder Than Solitude" },
    { id: 19, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8K9mxh-_NQEZkbeKEXl5vdKiy8nHT7zVhIL8TASmLKTbOKO0tgA&s", title: "19: What’s Important is Feeling" },
    { id: 20, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFWJqC2-oWjd4Y41dYAwgYohlTFsWxdVmMwKI1_bCG9TMXDAJKxA&s", title: "20: Blood Will Out" },
    { id: 21, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFWJqC2-oWjd4Y41dYAwgYohlTFsWxdVmMwKI1_bCG9TMXDAJKxA&s", title: "21: Cubed: A Secret History of the Workplace" },
    { id: 22, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8K9mxh-_NQEZkbeKEXl5vdKiy8nHT7zVhIL8TASmLKTbOKO0tgA&s", title: "22: The Last Illusion" },
    { id: 23, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFWJqC2-oWjd4Y41dYAwgYohlTFsWxdVmMwKI1_bCG9TMXDAJKxA&s", title: "23: Lost for Words: A Novel" },
    { id: 24, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFWJqC2-oWjd4Y41dYAwgYohlTFsWxdVmMwKI1_bCG9TMXDAJKxA&s", title: "24: Summer House With Swimming Pool" },
    { id: 25, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8K9mxh-_NQEZkbeKEXl5vdKiy8nHT7zVhIL8TASmLKTbOKO0tgA&s", title: "25: I’ll Be Right There" },
    { id: 26, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFWJqC2-oWjd4Y41dYAwgYohlTFsWxdVmMwKI1_bCG9TMXDAJKxA&s", title: "26: English Pronuciation in use" },
    { id: 27, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFWJqC2-oWjd4Y41dYAwgYohlTFsWxdVmMwKI1_bCG9TMXDAJKxA&s", title: "27: Cambridge English Skills Real Listening & Speaking" },
    { id: 28, image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8K9mxh-_NQEZkbeKEXl5vdKiy8nHT7zVhIL8TASmLKTbOKO0tgA&s", title: "28: Everyday Conversations English" },
]
