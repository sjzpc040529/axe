<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>淘汽档口管理系统</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="${basePath}/public/bootstrap/css/bootstrap.css">

    <link rel="stylesheet" type="text/css" href="${basePath}/public/css/theme.css">
    <link rel="stylesheet" href="${basePath}/public/css/font-awesome/font-awesome.css">

    <script src="public/jquery/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <!--&lt;!&ndash; Le HTML5 shim, for IE6-8 support of HTML5 elements &ndash;&gt;-->
    <!--&lt;!&ndash;[if lt IE 9]>-->
    <!--<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>-->
    <!--<![endif]&ndash;&gt;-->

    <!-- Le fav and touch icons -->
    <!--<link rel="shortcut icon" href="../assets/ico/favicon.ico">-->
    <!--<link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">-->
    <!--<link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">-->
    <!--<link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">-->
    <!--<link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">-->
</head>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
<!--<![endif]-->

<div class="navbar">
    <div class="navbar-inner">
        <ul class="nav pull-right">

        </ul>
        <a class="brand" href="index.jsp"><span class="first">淘汽</span> <span class="second">档口</span></a>
    </div>
</div>






<div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">淘汽档口管理系统</p>
            <div class="block-body">
                <form id="loginForm" action="${basePath}/sign/submit" method="post">
                    <label>用户</label>
                    <input type="text" class="span12" name="signName">
                    <label>密码</label>
                    <input type="password" class="span12">
                    <a id="a_submit" href="#" class="btn btn-primary pull-right">登录</a>
                    <label class="remember-me"><input type="checkbox">记住我</label>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
        <p class="pull-right" style=""><a href="http://www.tqmall.com" target="blank">tqmall</a></p>
        <p><a href="reset-password.html">忘记密码？</a></p>
    </div>
</div>





<script src="${basePath}/public/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
    $("[rel=tooltip]").tooltip();
    $(function() {
        $('.demo-cancel-click').click(function(){return false;});
        $('#a_submit').click(function(){

            $('#loginForm').submit();
        });
    });
</script>

</body>
</html>


