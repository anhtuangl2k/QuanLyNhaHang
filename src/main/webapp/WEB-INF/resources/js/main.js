/**
 * Template Name: Shuffle - v2.3.1
 * Template URL: https://bootstrapmade.com/bootstrap-3-one-page-template-free-shuffle/
 * Author: BootstrapMade.com
 * License: https://bootstrapmade.com/license/
 */

// HOME PAGE

!(function ($) {
    "use strict";

    // Stick the header at top on scroll
    $("#header").sticky({
        topSpacing: 0,
        zIndex: '50'
    });

    // Test fixed - scroll menu header


    // Smooth scroll for the navigation menu and links with .scrollto classes
    var scrolltoOffset = $('#header').outerHeight() - 1;
    $(document).on('click', '.nav-menu a, .mobile-nav a, .scrollto', function (e) {
        if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
            var target = $(this.hash);
            if (target.length) {
                e.preventDefault();

                var scrollto = target.offset().top - scrolltoOffset;

                if ($(this).attr("href") == '#header') {
                    scrollto = 0;
                }

                $('html, body').animate({
                    scrollTop: scrollto
                }, 1500, 'easeInOutExpo');

                if ($(this).parents('.nav-menu, .mobile-nav').length) {
                    $('.nav-menu .active, .mobile-nav .active').removeClass('active');
                    $(this).closest('li').addClass('active');
                }

                if ($('body').hasClass('mobile-nav-active')) {
                    $('body').removeClass('mobile-nav-active');
                    $('.mobile-nav-toggle i').toggleClass('icofont-navigation-menu icofont-close');
                    $('.mobile-nav-overly').fadeOut();
                }
                return false;
            }
        }
    });

    // Activate smooth scroll on page load with hash links in the url
    $(document).ready(function () {
        if (window.location.hash) {
            var initial_nav = window.location.hash;
            if ($(initial_nav).length) {
                var scrollto = $(initial_nav).offset().top - scrolltoOffset;
                $('html, body').animate({
                    scrollTop: scrollto
                }, 1500, 'easeInOutExpo');
            }
        }
    });

    // Mobile Navigation
    if ($('.nav-menu').length) {
        var $mobile_nav = $('.nav-menu').clone().prop({
            class: 'mobile-nav d-lg-none'
        });
        $('body').append($mobile_nav);
        $('body').prepend('<button type="button" class="mobile-nav-toggle d-lg-none"><i class="icofont-navigation-menu"></i></button>');
        $('body').append('<div class="mobile-nav-overly"></div>');

        $(document).on('click', '.mobile-nav-toggle', function (e) {
            $('body').toggleClass('mobile-nav-active');
            $('.mobile-nav-toggle i').toggleClass('icofont-navigation-menu icofont-close');
            $('.mobile-nav-overly').toggle();
        });

        $(document).on('click', '.mobile-nav .drop-down > a', function (e) {
            e.preventDefault();
            $(this).next().slideToggle(300);
            $(this).parent().toggleClass('active');
        });

        $(document).click(function (e) {
            var container = $(".mobile-nav, .mobile-nav-toggle");
            if (!container.is(e.target) && container.has(e.target).length === 0) {
                if ($('body').hasClass('mobile-nav-active')) {
                    $('body').removeClass('mobile-nav-active');
                    $('.mobile-nav-toggle i').toggleClass('icofont-navigation-menu icofont-close');
                    $('.mobile-nav-overly').fadeOut();
                }
            }
        });
    } else if ($(".mobile-nav, .mobile-nav-toggle").length) {
        $(".mobile-nav, .mobile-nav-toggle").hide();
    }

    // Navigation active state on scroll
    var nav_sections = $('section');
    var main_nav = $('.nav-menu, .mobile-nav');

    $(window).on('scroll', function () {
        var cur_pos = $(this).scrollTop() + 200;

        nav_sections.each(function () {
            var top = $(this).offset().top,
                    bottom = top + $(this).outerHeight();

            if (cur_pos >= top && cur_pos <= bottom) {
                if (cur_pos <= bottom) {
                    main_nav.find('li').removeClass('active');
                }
                main_nav.find('a[href="#' + $(this).attr('id') + '"]').parent('li').addClass('active');
            }
            if (cur_pos < 300) {
                $(".nav-menu ul:first li:first").addClass('active');
            }
        });
    });

    // Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });

    $('.back-to-top').click(function () {
        $('html, body').animate({
            scrollTop: 0
        }, 1500, 'easeInOutExpo');
        return false;
    });

    // Skills section
    $('.skills-content').waypoint(function () {
        $('.progress .progress-bar').each(function () {
            $(this).css("width", $(this).attr("aria-valuenow") + '%');
        });
    }, {
        offset: '80%'
    });

    // jQuery counterUp
    $('[data-toggle="counter-up"]').counterUp({
        delay: 10,
        time: 1000
    });

    // Porfolio isotope and filter
    $(window).on('load', function () {
        var portfolioIsotope = $('.portfolio-container').isotope({
            itemSelector: '.portfolio-item',
            layoutMode: 'fitRows'
        });

        $('#portfolio-flters li').on('click', function () {
            $("#portfolio-flters li").removeClass('filter-active');
            $(this).addClass('filter-active');

            portfolioIsotope.isotope({
                filter: $(this).data('filter')
            });
        });

        // Initiate venobox (lightbox feature used in portofilo)
        $(document).ready(function () {
            $('.venobox').venobox();
        });
    });

    // Portfolio details carousel
    $(".portfolio-details-carousel").owlCarousel({
        autoplay: true,
        dots: true,
        loop: true,
        items: 1
    });

})(jQuery);

// COMPANY DETAILS
function addComment(employerId) {
    fetch("/findingcareerproject/api/add-comment", {
        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("cmtId").value,
            "employerId": employerId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res);

        return res.json();
    }).then(function (data) {
        console.info(data);

        let area = document.getElementById("cmt-area");

        area.innerHTML = `  
                  <div class="comment-section">
                    <img src="${data.employee.avatarUrl}"/>
                    <div>
                        <label class="job-tit">${data.content}</label>
                        <p class="date-comment">${moment(data.createDate).fromNow()}</p>
                    </div>
                </div>` + area.innerHTML;
        location.reload();
    });
}

// RECRUITMENTS BY COMPANY

function deleteRecruitment(recruitmentid) {
    if (confirm("Do you want to delete this recruitment?") == true) {
        fetch(`/findingcareerproject/api/delete-recruitment/${recruitmentid}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => {
            if (res.status == 200) {
                location.reload();
            } else
                alert("Error!!");
        })
    }
}

function getRecruitments(employerId) {
    event.preventDefault();

    fetch("/findingcareerproject/api/get-amount-res", {
        method: 'post',
        body: JSON.stringify({
            "id": employerId,
            "amount": document.getElementsByClassName("jobbyc").length
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res);

        return res.json();
    }).then(function (data) {
        console.info(data);

        let area = document.getElementById("job-section");

        for (i = 0; i < data.length; i++) {
            area.innerHTML += `  
                   <div class="jobbyc col-md-12 col-lg-6 d-flex align-items-stretch mb-5 mb-lg-0 pb-4">
                            <div class="icon-box">
                                <div class="box2">
                                    <h4 class="title"><a href="${data[i].idRecruitment}">${data[i].title}</a></h4>
                                </div>
                            </div>
                        </div>`;
        }
    })
}
////HOVER ON FULL STAR

$(document).on('mouseenter', '.starr', function () {
    var index = $(this).data("index");

    for (i = 1; i <= index; i++) {
        $('#star-' + i).css('color', '#ffcc00');

    }
})
////LEAVE ON FULL STAR

$(document).on('mouseout', '.starr', function () {
    var index = $(this).data("index");

    for (i = 1; i <= index; i++) {
        $('#star-' + i).css('color', '#ccc');

    }
})

// CLICK TO RATING STAR

$(document).on('click', '.starr', function () {
    fetch("/findingcareerproject/api/rate-star", {
        method: 'post',
        body: JSON.stringify({
            "idEmployer": $(this).data("idcompany"),
            "star": $(this).data("index")
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => {
        if (res.status == 200) {
            location.reload();
        } else
            alert("Error!!");
    })
})

// WARNING STAR WAS RATED

$(document).on('click', '.star-rated', function () {
    alert("YOU HAD RATED STAR FOR THIS COMPANY BEFORE!!");
})

// ADD CV TO RECRUITMENT
function addCV(recruitmentid) {
    if (confirm("Do you want to apply your CV for this recruitment?") == true) {
        fetch(`/findingcareerproject/api/add-cv/${recruitmentid}`, {
            method: "get",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => {
            if (res.status == 200) {
                location.reload();
            } else
                alert("Error!!");
        })
    }
}
// ADD LIKE TO RECRUITMENT
function addReLike(recruitmentid) {
    fetch(`/findingcareerproject/api/add-re-like/${recruitmentid}`, {
        method: "get",
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {

        return res.json();
    }).then(function (data) {

        if (data === 1) {
            $('#like-section').css('background-color', '#87817f');
            $('#like-section').css('color', '#000');
        } else
            alert("Error!!");

    })
}
// ADD LIKE TO COMPANY
function addCoLike(recruitmentid) {
    fetch(`/findingcareerproject/api/add-co-like/${recruitmentid}`, {
        method: "get",
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {

        return res.json();
    }).then(function (data) {

        if (data === 1) {
            $('#like-section').css('background-color', '#87817f');
            $('#like-section').css('color', '#000');
        } else
            alert("Error!!");

    })
}

// SHOW EMPLOYEE DETAILS
function showEmployeeDetails(employeeId) {
    fetch(`/findingcareerproject/api/employer/employee-details/${employeeId}`, {
        method: "get",
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {

        return res.json();
    }).then(function (data) {
        let area = document.getElementById("info");

        var sex_section;
        var current_section;

        if (data[3] == true)
            sex_section = '<i class="fa fa-venus fa-lg" aria-hidden="true"></i>';
        else
            sex_section = '<i class="fa fa-mars fa-lg" aria-hidden="true"></i>';

        if (data[15] == true)
            current_section =
                    ` <p class="company">
                                <i class="fa fa-check" aria-hidden="true"></i>
                                Used to work in ${data[16]} company
                            </p>`;
        else
            current_section = `<p class="company"> 
                                <i class="fa fa-check" aria-hidden="true"></i>
                                Having worked in ${data[16]} company
                            </p>`;


        area.innerHTML = `           
         <div class="info" style="opacity: 1">
                    <div class="infor-section">
                        <div style="display : flex">
                            <h4 class="title" style="width : 70%">
                                ${data[0]}&nbsp;${data[1]}
                            </h4>` + sex_section +
                `</div>

                    </div>
                    <div>
                        <p class="email">
                            <i class="fa fa-envelope-o" aria-hidden="true"></i>&nbsp;
                            Email: ${data[2]}
                        </p>
                        <p class="phoneNumber">
                            <i class="fa fa-phone-square" aria-hidden="true"></i>&nbsp;
                            Contact: ${data[4]}
                        </p>
                        <p class="nationality">
                            <i class="fa fa-universal-access" aria-hidden="true"></i>&nbsp;
                            Nationality: ${data[5]}
                        </p>
                        <p class="subject">
                            <i class="fa fa-id-badge" aria-hidden="true"></i>&nbsp;
                            Subject: ${data[6]}
                        </p>
                        <p class="school">
                            <i class="fa fa-tags" aria-hidden="true"></i>&nbsp;
                            School: ${data[7]}
                        </p>
                        <p class="qualification">
                            <i class="fa fa-graduation-cap" aria-hidden="true"></i>&nbsp;
                            Qualification: ${data[8]}
                        </p>
                        <p class="skill">
                            <i class="fa fa-hand-paper-o" aria-hidden="true"></i>&nbsp;
                            Skill: ${data[9]}
                        </p>
                        <p class="language">
                            <i class="fa fa-language" aria-hidden="true"></i>&nbsp;
                            Language in used: ${data[10]}
                        </p>` + current_section +
                `<p class="offer">
                            <i class="fa fa-star" aria-hidden="true"></i>
                            Offer ${data[13]} salary for ${data[14]} postion
                        </p>
                    </div>
                </div>`;

    })
}

//UPDATE STATE cv
function updateState(idCv, state) {
    event.preventDefault();

    fetch("/findingcareerproject/api/update-cv", {
        method: 'post',
        body: JSON.stringify({
            "state": state,
            "idCV": idCv
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => {
        if (res.status === 200) {
            location.reload();
        } else
            alert("Error!!");
    })
}

// CHART STATISTIC
function generateColor() {
    let r = parseInt(Math.random() * 255);
    let g = parseInt(Math.random() * 255);
    let b = parseInt(Math.random() * 255);

    return `rgb(${r},${g},${b})`;
}

function cvChart(cvLabels = [], cvInfo = []) {
    let colors = [];

    for (let i = 0; i < cvInfo.length; i++)
        colors.push(generateColor());

    const data = {
        labels: cvLabels,
        datasets: [{
                label: 'Doughnut Chart For CV application',
                data: cvInfo,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };

    const config = {
        type: 'doughnut',
        data: data
    };

    let ctx = document.getElementById("doughnutchart").getContext("2d");
    new Chart(ctx, config);
}

function sendCondition() {
    let sM = document.getElementsByName("rbdM");
    let sY = document.getElementsByName("rdbY");

    var year;
    var period;

    for (var i = 0; i < sY.length; i++) {
        if (sY[i].checked == true)
            year = sY[i].value;
    }

    for (var i = 0; i < sM.length; i++) {
        if (sM[i].checked == true)
            period = sM[i].value;
    }
    
    getCVStatistic(period, year);
}
function getCVStatistic(period, year) {
    event.preventDefault();

    fetch("/findingcareerproject/api/cv-statis", {
        method: 'post',
        body: JSON.stringify({
            "period": period,
            "year": year
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {

        return res.json();
    }).then(function (data) {
        
        let area = document.getElementById("chartTable");
        let section = document.getElementById("doughnutchart");
        let cvLabels = [], cvInfo = [];

        data.forEach(i => {
            area.innerHTML += `
                                   <tr>
                                        <td>${i[0]}</td>
                                        <td>${i[2]}</td>
                                        <td>${i[3]}</td>                                        
                                    </tr>
                            `;
            cvLabels.push(i[2]);
            cvInfo.push(i[3]);
            
        });
        
        cvChart(cvLabels, cvInfo);
    });
}

// BROWSE EMPLOYER
function browseEmployer(state, id) {
    event.preventDefault();

    fetch("/findingcareerproject/api/browse-employer", {
        method: 'post',
        body: JSON.stringify({
            "state": state,
            "id": id
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => {
        if (res.status === 200) {
            location.reload();
        } else
            alert("Error!!");
    });
}