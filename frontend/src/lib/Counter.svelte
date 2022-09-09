<script>
    import Fa from 'svelte-fa'
    import {faThumbsUp} from '@fortawesome/free-solid-svg-icons'

    let items = [];
    let name = "";

    const addItem = () => {
        items = [
            ...items,
            {
                id: Math.random(),
                name,
                likes: 0,
            }
        ];
        name = "";
    };
    const remove = item => {
        items = items.filter(i => i !== item);
    };

    const like = item => {
        item.likes++;
        items = items.sort((a,b) => a.likes > b.likes ? -1 : 1);
    };

</script>
<div>
    <h1>Temaer</h1>
    <form on:submit|preventDefault={addItem}>
        <label for="name">Legg til forslag</label>
        <input id="name" type="text" bind:value={name}/>
    </form>

    <ul>
        {#each items as item}
            <li class:done={item.done}>
                <span>{item.name}</span>
                <button on:click={() => remove(item)}>&times;</button>
                <span>{item.likes}</span>
                <button class="like" on:click={() => like(item)}>
                    <Fa icon={faThumbsUp}/>
                </button>
            </li>
        {/each}
    </ul>
</div>

<style>
    div,
    #name {
        width: 100%;
    }

    form {
        margin-bottom: 0.5em;
    }

    input[type="text"] {
        outline: none;
        margin: 0;
    }

    input[type="text"]:focus {
        border-color: #dc4f21;
        box-shadow: 0 0 2px #dc4f21;
    }

    input[type="checkbox"] {
        margin: 0 10px 0 0;
    }


    li button {
        border: none;
        background: transparent;
        padding: 0;
        margin: 0;
        color: #dc4f21;
        font-size: 18px;
        cursor: pointer;
    }

    li button:hover {
        transform: scale(1.2);
    }

    li button:focus {
        outline: #dc4f21;
    }

    li:last-child {
        border-bottom: none;
    }

    .like {
        color: #a0bb5f;
    }

    label {
        display: block;
        text-transform: uppercase;
        font-size: 0.8em;
        color: #777;
    }

    li {
        list-style: none;
        padding: 6px 10px;
        border-bottom: 1px solid #ddd;
    }

    ul {
        padding-left: 0;
    }

    .done span {
        opacity: 0.4;
    }
</style>