<script>
  import Counter from './lib/Counter.svelte'
  import Aktivitet from './lib/Aktivitet.svelte'
  import { Router, Route, Link } from "svelte-routing";
  export let url = "";
</script>

<main>

  <Router url="{url}">
    <Counter/>
    <nav>
      <h1><Link to="/">Fagkveld</Link></h1>
      <Link to="aktivitet">Registrer Aktivitet</Link>
    </nav>
    <div>
      <Route path="aktivitet" component="{Aktivitet}" />
    </div>
    <Aktivitet></Aktivitet>
  </Router>

</main>
