<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html ng-app="podcastApp">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- inject:css -->
        <link rel="stylesheet" href="/js/lib/angular-loading-bar/src/loading-bar.css">
        <link rel="stylesheet" href="/js/lib/animate.css/animate.css">
        <link rel="stylesheet" href="/js/lib/ng-tags-input/ng-tags-input.min.css">
        <link rel="stylesheet" href="/js/lib/bootstrap/dist/css/bootstrap.css">
        <link rel="stylesheet" href="/js/lib/angular-hotkeys/build/hotkeys.min.css">
    <!-- endinject -->

    <link href="/css/podcastserver.css" rel="stylesheet" type="text/css">

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#compact-panel">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#/items">Podcast Server</a>
        </div>

        <div class="collapse navbar-collapse navbar-ex1-collapse" id="compact-panel">
            <ul class="nav navbar-nav">
                <li>
                    <a href="#/podcasts">
                            Podcast
                    </a>
                </li>
                <li>
                    <a href="#/item/search">
                        Rechercher
                    </a>
                </li>
                <li>
                    <a href="#/podcast/add">
                        Ajouter
                    </a>
                </li>
                <li>
                    <a href="#/download">
                        Téléchargement
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

    <div ng-view autoscroll=""></div>

<!-- inject:js -->
<script src="/js/lib/angular/angular.js"></script>
<script src="/js/lib/angular-route/angular-route.js"></script>
<script src="/js/lib/angular-animate/angular-animate.js"></script>
<script src="/js/lib/angular-sanitize/angular-sanitize.js"></script>
<script src="/js/lib/jquery/dist/jquery.js"></script>
<script src="/js/lib/angular-bootstrap/ui-bootstrap-tpls.js"></script>
<script src="/js/lib/lodash/dist/lodash.compat.js"></script>
<script src="/js/lib/stomp-websocket/lib/stomp.js"></script>
<script src="/js/lib/sockjs/sockjs.js"></script>
<script src="/js/lib/angular-local-storage/angular-local-storage.js"></script>
<script src="/js/lib/angular-truncate/src/truncate.js"></script>
<script src="/js/lib/angular-loading-bar/src/loading-bar.js"></script>
<script src="/js/lib/ng-tags-input/ng-tags-input.min.js"></script>
<script src="/js/lib/bootstrap/dist/js/bootstrap.js"></script>
<script src="/js/lib/restangular/dist/restangular.js"></script>
<script src="/js/lib/AngularStompDK/dist/angular-stomp.min.js"></script>
<script src="/js/lib/angular-hotkeys/build/hotkeys.min.js"></script>
<!-- endinject -->

<script src="<c:url value="/js/all.min.js"/>"></script>
<%--
<script src="<c:url value="/js/all.js"/>"></script>
--%>

</body>
</html>