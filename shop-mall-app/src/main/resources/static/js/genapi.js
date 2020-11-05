var vm = new Vue({
    el: '#rrapp',
    data: {
        title: null,
        api: {
            host: null,
            port: null,
            preUri: null
        }
    },
    methods: {
        genapi: function () {
            location.href = buildUrl("/generate/tool/generateApi", vm.api);
        },
        reset: function () {
            vm.api = {
                host: null,
                port: null,
                preUri: null
            };
        }
    }
});