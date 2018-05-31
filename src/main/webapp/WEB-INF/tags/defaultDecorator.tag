<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@attribute name="title" fragment="true"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content="Easy Living - Responsive Real Estate Template">
<meta name="keywords" content="Themes, real estate, responsive, themeforest, Templates">
<meta name="author" content="Rype Pixel [Chris Gipple]">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><jsp:invoke fragment="title" /></title>
<script src="${contextPath}/resources/default/html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<!-- CSS file links -->
<link href="${contextPath}/resources/default/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${contextPath}/resources/default/css/jquery.bxslider.css" rel="stylesheet" media="screen">
<link href="${contextPath}/resources/default/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}/resources/default/css/responsive.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}/resources/default/css/yamm.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}/resources/default/css/jquery.nouislider.min.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:700' rel='stylesheet' type='text/css'> 


        
<style>
.inputError,#requiredFiled{
color: red;
}
select{
	width: 100%;
    padding: 8px;
    margin-bottom: 20px;
    border-radius: 3px;
    border: none;
    border: 1px solid #c9c9c9;
    box-shadow: 0 1px 1px white;
}
</style>
    </head>
    

	
<header class="navbar yamm navbar-default navbar-fixed-top header2">
<div class="topBar">
    <div class="container">
        <p class="topBarText"><img class="icon" src="${contextPath}/resources/default/images/icon-phone.png" alt="" />1-800-192-0978</p>
        <p class="topBarText"><img class="icon" src="${contextPath}/resources/default/images/icon-mail.png" alt="" />info@easyLivingTheme.com</p>
        <ul class="socialIcons">
            <li class="topBarText"><a href="#">Login</a></li>
            <li class="topBarText"><a href="#">Register</a></li>
            <li><a href="#"><img src="${contextPath}/resources/default/images/icon-fb.png" alt="" /></a></li>
            <li><a href="#"><img src="${contextPath}/resources/default/images/icon-twitter.png" alt="" /></a></li>
            <li><a href="#"><img src="${contextPath}/resources/default/images/icon-google.png" alt="" /></a></li>
            <li><a href="#"><img src="${contextPath}/resources/default/images/icon-rss.png" alt="" /></a></li>
        </ul>
    </div>
</div>
<div class="container">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="${contextPath}/"><img src="${contextPath}/resources/default/images/logoGreen.png" alt="Easy Living" />EASY <span>LIVING</span></a>
    </div>
    <div class="navbar-collapse collapse">
        <!--  start login/register -->
        <ul class="userButtons">  
            <li class="userBtn"><a href="${contextPath}/login" class="buttonGrey">LOGIN</a></li>
            <li class="userBtn"><a href="${contextPath}/signup-page" class="buttonGrey">REGISTER</a></li>
        </ul>
        <!-- end login/register -->

        <ul class="nav navbar-nav">
            <li class="dropdown menu-item-has-children">
                <a href="${contextPath}/" class="${homeActive?'current':''}" >HOME</a>
            </li>
            <li class="dropdown menu-item-has-children">
                <a href="${contextPath}/property-listings" class="${propertyActive?'current':''}">LISTINGS</a>
            </li>
            <li class="dropdown menu-item-has-children">
                <a href="${contextPath}/agents-listing" class="${agentActive?'current':''}" >OUR AGENTS</a>
            </li>
            <li class="dropdown menu-item-has-children">
                <a href="${contextPath}/blogs-list" class="${blogActive?'current':''}" >BLOG</a>
            </li>
            <li class="dropdown yamm-fw">
                <a href="#" class="dropdown-toggle">MEGA MENU</a>
                <ul class="dropdown-menu">
                    <li> 
                        <div class="yamm-content">
                            <div class="row">
                            <div class="col-lg-4">
                                <!-- start recent posts widget -->
                                    <h4>RECENT POSTS</h4>
                                    <div class="recentPosts megaMenu">
                                        <h4><a href="#">AWESOME DREAM HOUSE IN A GREAT LOCATION</a></h4>
                                        <a href="#">READ MORE</a>
                                        <p class="date">Feb 5, 2014</p>
                                        <div style="clear:both;"></div>
                                        <div class="divider thin"></div>
                                        <h4><a href="#">AWESOME DREAM HOUSE IN A GREAT LOCATION</a></h4>
                                        <a href="#">READ MORE</a>
                                        <p class="date">Feb 5, 2014</p>
                                        <div style="clear:both;"></div>
                                        <div class="divider thin"></div>
                                        <h4><a href="#">AWESOME DREAM HOUSE IN A GREAT LOCATION</a></h4>
                                        <a href="#">READ MORE</a>
                                        <p class="date">Feb 5, 2014</p>
                                        <div style="clear:both;"></div>
                                    </div>
                                    <!-- end recent posts widget -->
                            </div>
                            <div class="col-lg-4 map">
                                <h4>GOOGLE MAPS</h4>
                                <iframe class="googleMap" src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=towson+md&amp;aq=&amp;sll=39.310394,-76.575394&amp;sspn=0.320357,0.676346&amp;ie=UTF8&amp;hq=&amp;hnear=Towson,+Baltimore,+Maryland&amp;ll=39.401495,-76.601912&amp;spn=0.019996,0.042272&amp;t=m&amp;z=14&amp;output=embed"></iframe><br/><br/>
                                <p>Lorem ipsum dolor amet, consectetur adipiscing elit. Sed ut purus eget nunc ut dignissim cursus at a nisl. 
                                Mauris vitae turpis quis eros egestas tempor sit amet a arcu.</p>
                            </div>
                            <div class="col-lg-4">
                                <h4>TEXT WIDGET</h4>
                                <p>Lorem ipsum dolor amet, consectetur adipiscing elit. Sed ut purus eget nunc ut dignissim cursus at a nisl. 
                                Mauris vitae turpis quis eros egestas tempor sit amet a arcu. Duis egestas hendrerit diam. Lorem ipsum dolor amet, consectetur adipiscing elit. Sed ut purus eget nunc ut dignissim cursus at a nisl. 
                                Mauris vitae turpis quis eros egestas tempor sit amet a arcu.</p>
                                <p>Lorem ipsum dolor amet, consectetur adipiscing elit. Sed ut purus eget nunc ut dignissim cursus at a nisl. 
                                Mauris vitae turpis quis eros egestas tempor sit amet a arcu. Duis egestas hendrerit diam. Lorem ipsum dolor amet.</p>
                            </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </li>
            <li class="dropdown menu-item-has-children">
                <a href="${contextPath}/contact-us" class="${contactActive?'current':''}" >CONTACT</a>
            </li>
        </ul>        
    </div>
</div>
</header>

<jsp:doBody />   

<footer id="footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-6">
                <h4><a class="footerLogo" href="#">
                	<img src="${contextPath}/resources/default/images/logoGreen.png" alt="Easy Living" />EASY <span>LIVING</span></a></h4>
                <p>Lorem ipsum dolor amet, consectetur adipiscing elit. Sed ut 
                purus eget nunc ut dignissim cursus at a nisl. Mauris vitae 
                turpis quis eros egestas tempor sit amet a arcu. Duis egestas 
                hendrerit diam.</p>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6">
                <h4>CONTACT</h4>
                <ul class="contactList">
                    <li><img class="icon" src="${contextPath}/resources/default/images/icon-pin.png" alt="" /> 123 Smith Drive, Arnold, Maryland</li>
                    <li><img class="icon" src="${contextPath}/resources/default/images/icon-phone.png" alt="" /> +1 234 567 8901</li>
                    <li><img class="icon" src="${contextPath}/resources/default/images/icon-mail.png" alt="" /> hello@thriveTheme.com</li>
                </ul>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6">
                <h4>TWITTER</h4>
                <ul>
                    <li><a href="#">@JohnDoe</a> Lorem ipsum dolor amet, 
                    adipiscing elit. Maecenas eget tellus.<br/><span>5 MINUTES AGO</span></li>
                    <li><a href="#">@JohnDoe</a> Lorem ipsum dolor amet, 
                    adipiscing elit. Maecenas eget tellus.<br/><span>5 MINUTES AGO</span></li>
                </ul>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6">
                <h4>NEWSLETTER</h4>
                <p>Lorem ipsum dolor amet, consectetur adipiscing elit. Sed ut 
                purus eget nunc ut dignissim cursus at a nisl.</p>
                <form class="subscribeForm" method="post" action="#">
                    <input type="text" name="email" value="Your email" class="input footer" />
                    <input type="submit" name="submit" value="SEND" class="buttonColor" />
                </form>
            </div>
        </div><!-- end row -->
    </div><!-- end footer container -->
</footer>

<div class="bottomBar">
    <div class="container">
        <p>EASY LIVING REAL ESTATE THEME COPYRIGHT 2013</p>
        <ul class="socialIcons">
            <li><a href="#"><img src="${contextPath}/resources/default/images/icon-fb.png" alt="" /></a></li>
            <li><a href="#"><img src="${contextPath}/resources/default/images/icon-twitter.png" alt="" /></a></li>
            <li><a href="#"><img src="${contextPath}/resources/default/images/icon-google.png" alt="" /></a></li>
            <li><a href="#"><img src="${contextPath}/resources/default/images/icon-rss.png" alt="" /></a></li>
        </ul>
    </div>
</div>

<!-- JavaScript file links -->
<script src="${contextPath}/resources/default/js/jquery.js"></script>           
<script src="${contextPath}/resources/default/js/bootstrap.min.js"></script>  
<script src="${contextPath}/resources/default/js/respond.js"></script>
<script src="${contextPath}/resources/default/js/jquery.bxslider.min.js"></script>  
<script src="${contextPath}/resources/default/js/tabs.js"></script>  
<script src="${contextPath}/resources/default/js/jquery.nouislider.min.js"></script> 
<script type="text/javascript" src="${contextPath}/resources/default/js/jquery.validate.js"></script>
<script type="text/javascript" src="${contextPath}/resources/default/js/custom-validation.js"></script>
<script src="${contextPath}/resources/default/js/countries.js"></script>  
<script>
//call bxslider for sub header section
$(document).ready(function(){
    $('.bxslider').bxSlider({
        auto: true,
        pager: false,
        nextSelector: '.slider-next',
        prevSelector: '.slider-prev',
        nextText: '<img src="${contextPath}/resources/default/images/slider-next.png" alt="slider next" />',
        prevText: '<img src="${contextPath}/resources/default/images/slider-prev.png" alt="slider prev" />'
    });
});
</script>
<script>
var Link = $.noUiSlider.Link;

$(".priceSlider").noUiSlider({
     range: {
      'min': 0,
      'max': 800000
    }
    ,start: [150000, 550000]
    ,step: 1000
    ,margin: 100000
    ,connect: true
    ,direction: 'ltr'
    ,orientation: 'horizontal'
    ,behaviour: 'tap-drag'
    ,serialization: {
        lower: [
            new Link({
                target: $("#price-min")
            })
        ],

        upper: [
            new Link({
                target: $("#price-max")
            })
        ],

        format: {
        // Set formatting
            decimals: 0,
            thousand: ',',
            prefix: '$'
        }
    }
});
</script>


<script language="javascript">print_country("country");</script>


</body>
</html>
