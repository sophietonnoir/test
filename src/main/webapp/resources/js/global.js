var load={
    script:function (location) {
        var script = document.createElement('script');
        script.src=location;
        document.body.appendChild(script);
        document.getElementsByTagName("script")[0].parentNode.removeChild(document.getElementsByTagName("script")[0]);
        
    }};

