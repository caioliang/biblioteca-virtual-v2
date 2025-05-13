import NavBar from "@/components/nav-bar";

export default function TransactionsPage() {
    return (
        <>
            <NavBar active="review" />

            <main className="flex justify-center">
                <div className="bg-slate-900 m-4 p-4 rounded min-w-1/3">
                    <h2>Review</h2>
                </div>
            </main>
        </>
    )
}